package cn.itcast.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName GlobalFilter
 * @Description TODO
 * @Author Enki
 * @Date 2024/8/19 11:11
 * @Verison 1.0
 **/
public interface GlobalFilter {
    /**
     * 过滤器 处理请求
     * @param exchange
     * @param chain
     * @return
     */
    Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain);

    void sayMyOrder();
}
