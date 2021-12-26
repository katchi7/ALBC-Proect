package com.ensias.albcuserService.controllers;

import com.ensias.albcuserService.dtos.*;
import com.ensias.albcuserService.exceptions.UserServiceException;
import com.ensias.albcuserService.model.User;
import com.ensias.albcuserService.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@Log4j2
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public HttpEntity<OperationResponse> createUser( @RequestBody @Valid UserCreationDto dto, Errors errors, HttpServletRequest request){
        log.info(dto);
        if(errors.hasErrors()){
            throw new UserServiceException(HttpStatus.BAD_REQUEST,"Invalid data");
        }
        if(!dto.passwordValid()) throw new UserServiceException(HttpStatus.BAD_REQUEST,"passwords does not match");
        userService.createUser(dto.asUser());
        return ResponseEntity.ok(new OperationResponse(HttpStatus.CREATED.value(),null,"User Created",request.getServletPath()));
    }

    @GetMapping("/{id}")
    public HttpEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        return ResponseEntity.ok(new UserDto(userService.getUserById(userId)));
    }
    @PutMapping("/updateUser")
    public HttpEntity<OperationResponse> updateUser(@RequestBody @Valid UserDto dto,Errors errors,HttpServletRequest request){
        if(errors.hasErrors()){
            if(!dto.validId()) throw new UserServiceException(HttpStatus.BAD_REQUEST,"User id must be specified");
            if(errors.hasFieldErrors("fullName")&&
                    errors.hasFieldErrors("email")&&
                    errors.hasFieldErrors("phone")&&
                    errors.hasFieldErrors("userName")) throw new UserServiceException(HttpStatus.BAD_REQUEST,"a field must be valid");
        }

        User user = userService.getUserById(dto.getId());
        user.setFullName(errors.hasFieldErrors("fullName")? user.getFullName() : dto.getFullName());
        user.setPhone(errors.hasFieldErrors("phone")? user.getPhone() : dto.getPhone());
        user.setEmail(errors.hasFieldErrors("email")? user.getEmail() : dto.getEmail());
        user.setUserName(errors.hasFieldErrors("username")? user.getUserName() : dto.getUserName());
        userService.createUser(user);
        return ResponseEntity.ok(new OperationResponse(HttpStatus.OK.value(),null ,"User updated",request.getServletPath()));
    }
    @PostMapping("/updatePassword")
    public HttpEntity<OperationResponse> updateUserPassword(@RequestBody @Valid PasswordUpdateDto dto,Errors errors, HttpServletRequest request){
        if(errors.hasErrors()){
            throw new UserServiceException(HttpStatus.BAD_REQUEST,"Fields are not valid");
        }
        userService.updateUserPassword(dto.getId(), dto.getOldPassword(), dto.getNewPassword());
        return ResponseEntity.ok(new OperationResponse(HttpStatus.OK.value(), null,"Password Updated",request.getServletPath()));
    }
    @PostMapping("/validateUsernamePassword")
    public HttpEntity<UserDto> validateUserNamePassword(@RequestBody @Valid LoginDto dto,Errors errors){
        if(errors.hasErrors()) throw new UserServiceException(HttpStatus.BAD_REQUEST,"Bad request body");
        log.info(dto);
        return ResponseEntity.ok(new UserDto(userService.validateUserNamePassword(dto.getLogin(), dto.getPassword())));
    }
    @PostMapping("/deactivateAccount")
    public HttpEntity<OperationResponse> deactivateAccount(@RequestBody UserDto dto,HttpServletRequest request){
        if(!dto.validId()) throw new UserServiceException(HttpStatus.BAD_REQUEST,"invalid ID");
        User user = userService.getUserById(dto.getId());
        user.setAccountActivated(false);
        userService.createUser(user);
        return ResponseEntity.ok(new OperationResponse(HttpStatus.OK.value(),null,"Account deactivated",request.getServletPath()));
    }
    @PostMapping("/getUserBylogin")
    public HttpEntity<UserDto> getUserByLogin(@RequestBody LoginDto loginDto){
        log.info(loginDto);
        if(loginDto==null || loginDto.getLogin()==null){
            throw new UserServiceException(HttpStatus.BAD_REQUEST,"Login is not valid");
        }
        return ResponseEntity.ok(new UserDto(userService.findUserBLogin(loginDto.getLogin())));
    }
    @GetMapping("/findOthers")
    public HttpEntity<List<UserDto>> getOtherUsers(@RequestParam("userId") Long userId){
        return ResponseEntity.ok(userService.findOtherUsers(userId).stream().map(UserDto::new).collect(Collectors.toList()));
    }
    @PostMapping("/getAllUsers")
    public  HttpEntity<List<UserDto>> getAllUsers(@RequestBody List<Long> userIds){
        return ResponseEntity.ok(userService.findAllUsers(userIds).stream().map(UserDto::new).collect(Collectors.toList()));
    }
}
