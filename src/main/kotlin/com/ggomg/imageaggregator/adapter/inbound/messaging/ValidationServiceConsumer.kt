package com.ggomg.imageaggregator.adapter.inbound.messaging

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.ggomg.imageaggregator.adapter.inbound.message.MessageBody
import com.ggomg.imageaggregator.adapter.inbound.message.MessageHeader
import com.ggomg.imageaggregator.adapter.inbound.message.ValidationServiceData
import com.ggomg.imageaggregator.application.port.inbound.ValidationResultMessageHandler
import com.ggomg.imageaggregator.application.port.inbound.command.ServiceCommand
import com.ggomg.imageaggregator.application.port.inbound.command.ValidationResultCommand
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.stereotype.Component

@Component
class ValidationServiceConsumer(
    private val validationResultMessageHandler: ValidationResultMessageHandler,
    private val objectMapper: ObjectMapper
) {
    @RabbitListener(queues = ["\${services.image.validation.queue}"])
    fun handleOcrMessage(
        @Headers headers: Map<String, Any>,
        body: String
    ) {
        val messageHeader = objectMapper.convertValue(headers, MessageHeader::class.java)
        val messageBody: MessageBody<ValidationServiceData> = objectMapper.readValue(
            body,
            object : TypeReference<MessageBody<ValidationServiceData>>() {}
        )
        println("[ValidationService] 수신 메시지: $messageBody")

        val command = ServiceCommand(
            gid = messageBody.gid,
            status = messageBody.status,
            completedAt = messageBody.completedAt,
            data = ValidationResultCommand(
                isBlank = messageBody.payload.isBlank,
            ),
        )

        println("[ValidationService] AMQP 헤더: $messageHeader")
        validationResultMessageHandler.handleMessage(command)
    }
}