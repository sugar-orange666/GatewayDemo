package com.example.gatewaydemo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Date：2024/4/15 15:24
 * @Description
 */


@Component
public class MyGlobalFilter implements GlobalFilter {
    private Logger logger = LoggerFactory.getLogger(MyGlobalFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("执行全局过滤器-logger");
        return chain.filter(exchange);
    }

}
