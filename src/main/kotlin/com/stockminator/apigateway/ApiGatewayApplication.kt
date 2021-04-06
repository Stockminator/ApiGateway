package com.stockminator.apigateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import java.util.function.Function

@SpringBootApplication
class ApiGatewayApplication {

    @Bean
    fun customRouteLocator(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
                .route("hello") { r -> r.path("/hello").uri("http://localhost:7576/hello") }
                .route("bello") { r -> r.path("/bello").uri("http://localhost:7576/bello") }
                .build()
    }
}

fun main(args: Array<String>) {
    runApplication<ApiGatewayApplication>(*args)
}
