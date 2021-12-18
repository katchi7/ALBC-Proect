package com.ensias.albcauthenticationserver.api;

import com.ensias.albcauthenticationserver.dtos.LoginDto;
import com.ensias.albcauthenticationserver.dtos.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "albc-user-service",name = "albc-user-service",path = "/albc-project/user-service")
public interface UserServiceApi {
    @PostMapping("/user/validateUsernamePassword")
    UserDto validateUserNamePassword(@RequestBody LoginDto dto);
    @PostMapping("/user/getUserBylogin")
    UserDto findUserByLogin(@RequestBody LoginDto dto);
}
