package com.jason.webflux.router.router;
import com.jason.webflux.router.hander.CityHandler2;
import com.jason.webflux.router.hander.TimeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
/**
 * @auther: xieyong
 * @date: 2018/8/28 10:02
 * @Description: router
 */
@Configuration
public class CityRouter {

    @Bean
    public RouterFunction<ServerResponse> routeCity(CityHandler2 cityHandler,TimeHandler timeHandler) {
        return route(GET("/hello").
                        and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        cityHandler::helloCity)
                .andRoute(GET("/time"),timeHandler::getTime)
                .andRoute(GET("/date"),timeHandler::getDate)
                .andRoute(GET("/times"),timeHandler::sendTimePerSec);
    }
}
