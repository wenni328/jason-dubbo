package com.jason.webflux.mongodb.router.router;

import com.jason.webflux.mongodb.router.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author: xieyong
 * @date: 2018/8/29 14:55
 * @Description:
 */
@Configuration
public class UserRouter {
    @Bean
    public RouterFunction<ServerResponse> routerUser(UserHandler userHandler) {
        return route(GET("/router/{username}").
                and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), userHandler::routerGetUser);
    }
}
