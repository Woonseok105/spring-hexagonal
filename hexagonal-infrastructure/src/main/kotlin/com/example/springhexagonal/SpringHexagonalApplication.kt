package com.example.springhexagonal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class SpringHexagonalApplication

fun main(args: Array<String>) {
    runApplication<SpringHexagonalApplication>(*args)
}
