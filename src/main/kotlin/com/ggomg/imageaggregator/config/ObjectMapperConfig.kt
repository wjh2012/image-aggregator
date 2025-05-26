package com.ggomg.imageaggregator.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ObjectMapperConfig {
    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper().registerKotlinModule()
            .registerModule(JavaTimeModule()) // Java 8 Date/Time 지원
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) // ISO-8601 포맷 사용
    }
}