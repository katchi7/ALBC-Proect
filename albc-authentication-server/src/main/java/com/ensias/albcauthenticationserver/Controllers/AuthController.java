package com.ensias.albcauthenticationserver.Controllers;

import com.ensias.albcauthenticationserver.dtos.AccessValidationDto;
import com.ensias.albcauthenticationserver.dtos.LoginDto;
import com.ensias.albcauthenticationserver.dtos.OperationResponse;
import com.ensias.albcauthenticationserver.dtos.UserDto;
import com.ensias.albcauthenticationserver.models.User;
import com.ensias.albcauthenticationserver.services.UserService;
import com.ensias.albcauthenticationserver.tools.JwtUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Log4j2
public class AuthController {
    @Value("${jwt.hdr}")
    public String TOKEN_HEADER;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final WebInvocationPrivilegeEvaluator privilegeEvaluator;
    public AuthController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil, WebInvocationPrivilegeEvaluator privilegeEvaluator) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.privilegeEvaluator = privilegeEvaluator;
    }

    @PostMapping(value = "/login")
    public HttpEntity<UserDto> login(@RequestBody LoginDto userDto){
        log.info(userDto);
        try {
            User user = userService.validate(userDto.getLogin(),userDto.getPassword());
            if(user==null || user.getId()==null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getLogin(),userDto.getPassword()));
            UserDto userDto1 = new UserDto(user);
            String token = jwtUtil.generateToken(userDto.getLogin());
            userDto1.setToken(token);
            return ResponseEntity.ok().header(TOKEN_HEADER,token).body(userDto1);


        }catch (org.springframework.security.core.AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping(value ="/validate")
    public HttpEntity<OperationResponse> validateAccess(@RequestBody AccessValidationDto dto, HttpServletRequest request){
        boolean allowed = privilegeEvaluator.isAllowed(dto.getUrl(), SecurityContextHolder.getContext().getAuthentication());
        if(allowed){
            return ResponseEntity.ok(new OperationResponse(HttpStatus.OK.value(), null,"Access allowed",request.getServletPath()));
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new OperationResponse(HttpStatus.UNAUTHORIZED.value(), null,"Access not allowed",request.getServletPath()));

        }
    }
}
