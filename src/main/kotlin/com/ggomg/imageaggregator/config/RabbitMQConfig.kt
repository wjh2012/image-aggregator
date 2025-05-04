package com.ggomg.imageaggregator.config

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig(private val imageQueueProperties: ImageQueueProperties) {

    @Bean
    fun ocrQueue(): Queue {
        return Queue(imageQueueProperties.ocr.queue, true)
    }

    @Bean
    fun ocrExchange(): DirectExchange {
        return DirectExchange(imageQueueProperties.ocr.exchange)
    }

    @Bean
    fun ocrBindingQueue(): Binding {
        return BindingBuilder.bind(ocrQueue())
            .to(ocrExchange())
            .with(imageQueueProperties.ocr.routingKey)
    }

    @Bean
    fun validationQueue(): Queue {
        return Queue(imageQueueProperties.validation.queue, true)
    }

    @Bean
    fun validationExchange(): DirectExchange {
        return DirectExchange(imageQueueProperties.validation.exchange)
    }

    @Bean
    fun validationBindingQueue(): Binding {
        return BindingBuilder.bind(validationQueue())
            .to(validationExchange())
            .with(imageQueueProperties.validation.routingKey)
    }
}