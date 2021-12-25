package com.ensias.albcusertimelineservice.api;



import com.ensias.albcusertimelineservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "albc-user-service",name = "albc-user-service",path = "/albc-project/user-service")
public interface UserServiceApi {
    @GetMapping("/user/{id}")
    User getUser(@PathVariable("id") Long id);
}
