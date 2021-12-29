package com.ensias.albcgateway.filters;

import com.ensias.albcgateway.api.AuthServiceApi;
import com.ensias.albcgateway.dto.AccessValidationDto;
import com.ensias.albcgateway.dto.OperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;


@Component
public class AccessValidationFilter extends AbstractGatewayFilterFactory<Object> {
    @Autowired
    AuthServiceApi api;
    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {


            ServerHttpRequest request = exchange.getRequest();
            String token = request.getHeaders().getFirst("JWT-TOKEN");

            if(token==null){
                token = request.getHeaders().getFirst("Authorization");
                token = token!=null?token.replace("Bearer ",""):null;
            }

            String path = request.getPath().value();
            System.out.println("path : "+path+" Token : "+token);
            AccessValidationDto body = new AccessValidationDto();
            body.setUrl(path);
            HttpEntity<OperationResponse> response = api.validateAccess(token,body);

            System.out.println(response.getHeaders());
            if( response != null && HttpStatus.OK.equals(HttpStatus.valueOf( response.getBody().getStatus()))){
                return chain.filter(exchange);
            }
            // FAIL
            exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
            return exchange.getResponse().setComplete();
        };
    }



    public static class Config{

    }
}
