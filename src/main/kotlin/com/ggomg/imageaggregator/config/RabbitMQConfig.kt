package com.ggomg.imageaggregator.config

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class RabbitMQConfig(private val imageQueueProperties: ImageQueueProperties) {

    @Bean
    fun batchListenerContainerFactory(connectionFactory: ConnectionFactory): RabbitListenerContainerFactory<*> {
        val factory = SimpleRabbitListenerContainerFactory()
        factory.setConnectionFactory(connectionFactory)

        factory.setBatchListener(true)
        factory.setConsumerBatchEnabled(true)
        factory.setBatchSize(10)
        factory.setReceiveTimeout(1000L)
        factory.setPrefetchCount(10)

        return factory
    }

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

    @Bean
    fun thumbnailQueue(): Queue {
        return Queue(imageQueueProperties.thumbnail.queue, true)
    }

    @Bean
    fun thumbnailExchange(): DirectExchange {
        return DirectExchange(imageQueueProperties.thumbnail.exchange)
    }

    @Bean
    fun thumbnailBindingQueue(): Binding {
        return BindingBuilder.bind(thumbnailQueue())
            .to(thumbnailExchange())
            .with(imageQueueProperties.thumbnail.routingKey)
    }
}