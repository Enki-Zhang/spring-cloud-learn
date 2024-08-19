package cn.itcast.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName AuthorizeFilter
 * @Description 验证参数中是否有满足条件的请求
 * @Author Enki
 * @Date 2024/8/19 11:22
 * @Verison 1.0
 **/
@Order(1)
@Component
//@Slf4j
public class AuthorizeFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
////        获取请求头
//        ServerHttpRequest request = exchange.getRequest();
////        获取参数 判断是否有authorization
//        String authorization = request.getQueryParams().getFirst("authorization");
////        authorization
//        if ("authorization".equals(authorization)) {
////            放行
//            return chain.filter(exchange);
//        }
////        拦截并禁止访问
//        exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
//        return exchange.getResponse().setComplete();
        ServerHttpRequest request = exchange.getRequest();
        System.out.println("GlobalFilter - Pre Request Processing: " + request.getURI());

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            ServerHttpResponse response = exchange.getResponse();
//            System.out.println("GlobalFilter - Post Response Processing: " + response.getStatusCode());
//            log.info("GlobalFilter - Post Response Processing: " + response.getStatusCode());
        }));
    }

    @Override
    public void sayMyOrder() {
        System.out.println("我是全局过滤器");
    }
}
