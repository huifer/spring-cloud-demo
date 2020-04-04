package org.huifer.springcloud.gateway.filter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class AuthFilter implements GlobalFilter, Ordered {
    private static final Logger LOG = LoggerFactory.getLogger(AuthFilter.class);
    public static final String TID = "tid";
    public static final String TOKEN = "TOKEN";
    private AtomicInteger atomicInteger = new AtomicInteger(-1);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String token = request.getHeaders().getFirst(TOKEN);
        String tid = request.getHeaders().getFirst(TID);
        if (StringUtils.isBlank(tid)) {
            tid = UUID.randomUUID().toString().replaceAll("-", StringUtils.EMPTY);
            atomicInteger.addAndGet(1);
            System.out.println("设置了 " + atomicInteger.get() + "次数");

            System.out.println(tid);
            request = request.mutate().header(TID, tid).build();
            exchange = exchange.mutate().request(request).build();
        }
        LOG.info("token={}, tid={}", token, tid);
        response.getHeaders().add(TID, tid);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
