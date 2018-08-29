package com.jason.webflux.mongodb.router.handler;

import com.jason.webflux.mongodb.entity.User;
import com.jason.webflux.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author: xieyong
 * @date: 2018/8/29 09:53
 * @Description:
 */
@Component
public class UserHandler {

    @Autowired
    private UserService userService;

    public Mono<ServerResponse> routeGetAll() {
        return ServerResponse.ok().body(userService.findAll(), User.class);
    }

    public Mono<ServerResponse> routerGetUser(ServerRequest request) {
        return userService.findByUsername(request.pathVariable("username"))
                .flatMap(user -> ServerResponse.ok().body(Mono.just(user), User.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

//    @Bean
//    public Mono<ServerResponse> routerPostUser(ServerRequest request){
//
//        return  ServerResponse.ok().build(userService.save(request.bodyToMono(User.class)));
//    }
}
