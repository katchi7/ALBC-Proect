package com.ensias.albchometimelineservice.api;


import com.ensias.albchometimelineservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "albc-user-service",name = "albc-user-service",path = "/albc-project/user-service")
public interface UserServiceApi {
    @GetMapping("/user/{id}")
    User getUser(@PathVariable("id") Long id);
    @GetMapping("/user/findOthers")
    List<User> getOtherUser(@RequestParam("userId") Long id);
}
