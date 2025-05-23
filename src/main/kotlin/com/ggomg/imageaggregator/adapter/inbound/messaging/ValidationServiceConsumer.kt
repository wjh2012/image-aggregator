package com.ggomg.imageaggregator.adapter.inbound.messaging

import com.fasterxml.jackson.databind.ObjectMapper
import com.ggomg.imageaggregator.adapter.inbound.message.ThumbnailServiceMessage
import com.ggomg.imageaggregator.adapter.inbound.message.ValidationServiceMessage
import com.ggomg.imageaggregator.application.port.inbound.ValidationResultMessageHandler
import com.ggomg.imageaggregator.application.port.inbound.command.ThumbnailResultCommand
import com.ggomg.imageaggregator.application.port.inbound.command.ValidationResultCommand
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class ValidationServiceConsumer(
    private val validationResultMessageHandler: ValidationResultMessageHandler,
    private val objectMapper: ObjectMapper
) {
    @RabbitListener(queues = ["\${services.image.validation.queue}"])
    fun handleOcrMessage(message: String) {
        val validationMessage =
            objectMapper.readValue(message, ValidationServiceMessage::class.java)
        println("[ThumbnailService] 수신 메시지: $validationMessage")

        val command = ValidationResultCommand(
            gid = validationMessage.validationMessagePayload.gid,
            status = validationMessage.validationMessagePayload.status,
            completedAt = validationMessage.validationMessagePayload.completedAt,
            validationResults = validationMessage.validationMessagePayload.validationResults,
        )

        validationResultMessageHandler.handleMessage(command)
    }
}