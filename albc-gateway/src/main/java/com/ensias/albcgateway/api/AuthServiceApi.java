package com.ensias.albcgateway.api;

import com.ensias.albcgateway.dto.AccessValidationDto;
import com.ensias.albcgateway.dto.OperationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "albc-authentication-service",path = "/albc-project/authentication-service")
public interface AuthServiceApi {
    @PostMapping("/validate")
    HttpEntity<OperationResponse> validateAccess(@RequestHeader("JWT-TOKEN") String token, @RequestBody AccessValidationDto dto);
}
