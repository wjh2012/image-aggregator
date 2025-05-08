package com.ggomg.imageaggregator.adapter.`in`.messaging

import com.ggomg.imageaggregator.application.port.`in`.ValidationResultMessageHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class ValidationConsumer(
    private val ValidationResultMessageHandler: ValidationResultMessageHandler,
) {

    @RabbitListener(queues = ["\${services.image.validation.queue}"])
    fun handleValidationMessage(message: String) {
        println("[Validation] 수신 메시지: $message")
        ValidationResultMessageHandler.handleMessage(message)
    }
}