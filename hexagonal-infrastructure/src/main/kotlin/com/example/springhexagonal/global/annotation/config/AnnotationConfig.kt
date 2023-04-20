package com.example.springhexagonal.global.annotation.config

import com.example.springhexagonal.annotation.Spi
import com.example.springhexagonal.annotation.UseCase
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan (
        basePackages = ["com.example.springhexagonal"],
        includeFilters = [
            Filter (
                    type = FilterType.ANNOTATION,
                    classes = [
                        UseCase::class,
                        Spi::class
                    ]
            )
        ]
)
class AnnotationConfig {
}