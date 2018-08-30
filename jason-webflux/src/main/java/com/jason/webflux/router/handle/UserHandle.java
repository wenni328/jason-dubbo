package com.jason.webflux.router.handle;

import com.jason.webflux.entity.User;
import com.jason.webflux.repository.UserRepository;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;


/**
 * @author: xieyong
 * @date: 2018/8/30 15:52
 * @Description:
 */
@Component
public class UserHandle {

    @Autowired
    private UserRepository userRepository;

    public Mono<ServerResponse> getTime(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("Now is " + new SimpleDateFormat("HH:mm:ss").format(new Date())), String.class);
    }

    public Mono<ServerResponse> getDate(ServerRequest serverRequest) {
        return ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("Today is " + new SimpleDateFormat("yyyy-MM-dd").format(new Date())), String.class);
    }

    public Mono<User> getUserById(ServerRequest serverRequest) {
     return userRepository.findByUsername(serverRequest.pathVariable("username"));
    }

    public Mono<Void> add(Publisher<User> userPublisher){
        return userRepository.insert(userPublisher).then();
    }
}
