package com.ggomg.imageaggregator.adapter.`in`.messaging

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class ValidationConsumer {

    @RabbitListener(queues = ["\${services.image.validation.queue}"])
    fun handleValidationMessage(message: String) {
        println("[Validation] 수신 메시지: $message")
    }
}