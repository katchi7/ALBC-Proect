package com.ensias.albcauthenticationserver.Controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @GetMapping("/")
    public HttpEntity<String> getEndpoint(){
        return ResponseEntity.ok("test");
    }
}
