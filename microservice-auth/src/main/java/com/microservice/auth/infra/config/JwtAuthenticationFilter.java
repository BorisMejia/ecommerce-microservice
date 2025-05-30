package com.microservice.auth.infra.config;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter implements ServerAuthenticationConverter {

    private final JwtProvider jwtProvider;

    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            return Mono.empty();
        }
        String token = authHeader.substring(7);
        if (!jwtProvider.isTokenValid(token)){
            return Mono.empty();
        }
        String userId = jwtProvider.extractUserId(token);
        return Mono.just(new UsernamePasswordAuthenticationToken(userId, null, List.of()));
    }
}
