package com.ggomg.imageaggregator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class ImageAggregatorApplication

fun main(args: Array<String>) {
    runApplication<ImageAggregatorApplication>(*args)
}
