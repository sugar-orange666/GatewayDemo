package com.example.gatewaydemo.component;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Date：2024/4/15 11:34
 * @Description
 */
@Component
public class AbcComponent implements KeyResolver {
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        //just方法标识根据什么进行限流  这么写代表根据主机名称进行限流
        return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }
}
