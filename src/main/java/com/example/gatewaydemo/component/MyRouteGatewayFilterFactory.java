package com.example.gatewaydemo.component;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.support.GatewayToStringStyler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义全局过滤器
 * @Date：2024/4/15 15:29
 * @Description
 */
@Component
public class MyRouteGatewayFilterFactory extends AbstractGatewayFilterFactory<MyRouteGatewayFilterFactory.Config> {

    public MyRouteGatewayFilterFactory() {
        super(MyRouteGatewayFilterFactory.Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                System.out.println("filter拦截   的name：" + config.getName() + ",age:" + config.getAge());
                return chain.filter(exchange);
            }

            @Override
            public String toString() {
                return GatewayToStringStyler.filterToStringCreator(MyRouteGatewayFilterFactory.this).append("name", config.getName()).toString();
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("name");
    }

    public static class Config {
        private String name;
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Config() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

