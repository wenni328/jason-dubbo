package com.jason.webflux.router.router;

import com.jason.webflux.router.handle.UserHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author: xieyong
 * @date: 2018/8/30 15:52
 * @Description:
 */
@Configuration
public class UserRouter {
    @Autowired
    private UserHandle userHandle;

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return route(GET("/time"), userHandle::getTime)
                .andRoute(GET("/date"), userHandle::getDate);
    }
}
