package com.jason.webflux.router.hander;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: xieyong
 * @date: 2018/8/28 10:01
 * @Description:
 */
@Component
public class CityHandler2 {
    public Mono<ServerResponse> helloCity(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello, City!"));
    }
    public Mono<ServerResponse> timeFunction() {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(
                Mono.just("Now is " + new SimpleDateFormat("HH:mm:ss").format(new Date())), String.class);
    }

    public Mono<ServerResponse> dateFunction() {
        return  ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(
                Mono.just("Today is " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())), String.class);
    }
}
