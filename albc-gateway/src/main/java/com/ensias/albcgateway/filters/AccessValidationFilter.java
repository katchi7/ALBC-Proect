package com.ensias.albcgateway.filters;

import com.ensias.albcgateway.api.AuthServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
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
            System.out.println(token);
            String path = request.getPath().value();
            System.out.println(path);
            /*
            HttpEntity<OperationResponse> response = api.validateAccess(token,new AccessValidationDto(path));
            System.out.println(response.getHeaders());
            if( response != null && HttpStatus.OK.equals(HttpStatus.valueOf( response.getBody().getStatus()))){
                return chain.filter(exchange);
            }
            // FAIL
            exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
            return exchange.getResponse().setComplete();
             */
            return chain.filter(exchange);
        };
    }



    public static class Config{

    }
}
