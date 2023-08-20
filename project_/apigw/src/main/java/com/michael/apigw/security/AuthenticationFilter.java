package com.michael.apigw.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private RouteValidator routeValidator;

    @Autowired
    private JWTService jwtService;


    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if (routeValidator.isSecured.test(exchange.getRequest())) {
                //header contatins token or not
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("Missing authorization header");
                }
                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }
                try{
                    //Reset call to auth service
         //           restTemplate.getForObject("http:://IDENTETY-SERVICE/validate?token"+authHeader, String.class);
                    jwtService.validateToken(authHeader);
                }catch (Exception ex){
                    throw new RuntimeException(String.format("un authorized access to application"));
                }

            }
            return chain.filter(exchange);
        });
    }

    public static class Config {

    }
}
