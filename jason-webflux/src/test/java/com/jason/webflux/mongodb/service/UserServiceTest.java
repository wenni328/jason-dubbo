package com.jason.webflux.mongodb.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @author: xieyong
 * @date: 2018/8/28 20:33
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserServiceTest {

    @Test
    public void save() {
    }

    @Test
    public void deleteByUsername() {
    }

    @Test
    public void findByUsername() {
        WebClient webClient = WebClient.create("http://localhost:8082");   // 1
        Mono<String> resp = webClient
                .get().uri("/user") // 2
                .retrieve() // 3
                .bodyToMono(String.class);  // 4
        resp.subscribe(System.out::println);    // 5
        try {
            TimeUnit.SECONDS.sleep(1);  // 6
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAll() {
    }
}
