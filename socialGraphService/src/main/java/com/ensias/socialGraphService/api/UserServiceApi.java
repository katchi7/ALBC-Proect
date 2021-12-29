package com.ensias.socialGraphService.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ensias.socialGraphService.dto.UserDto;

@FeignClient(value = "albc-user-service",name = "albc-user-service",path = "/albc-project/user-service")
public interface UserServiceApi {
    @PostMapping("/user/getUserBylogin")
    List<UserDto> getUser(@RequestBody List<Long> userIds);
}