package com.ggomg.imageaggregator.adapter.inbound.message.consumer

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.ggomg.imageaggregator.adapter.inbound.message.dto.MessageBody
import com.ggomg.imageaggregator.adapter.inbound.message.dto.MessageHeader
import com.ggomg.imageaggregator.adapter.inbound.message.dto.ValidationServicePayload
import com.ggomg.imageaggregator.domain.port.inbound.message.SaveValidationResultUseCase
import com.ggomg.imageaggregator.domain.port.inbound.message.command.ServiceCommand
import com.ggomg.imageaggregator.domain.port.inbound.message.command.ValidationResultCommand
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.stereotype.Component
import java.time.OffsetDateTime

@Component
class ValidationServiceConsumer(
    private val saveValidationResultUseCase: SaveValidationResultUseCase,
    private val objectMapper: ObjectMapper
) {
    @RabbitListener(queues = ["\${services.image.validation.queue}"])
    fun handleOcrMessage(
        @Headers headers: Map<String, Any>,
        body: String
    ) {
        val messageHeader = objectMapper.convertValue(headers, MessageHeader::class.java)
        val messageBody: MessageBody<ValidationServicePayload> = objectMapper.readValue(
            body,
            object : TypeReference<MessageBody<ValidationServicePayload>>() {}
        )
        println("[ValidationService] 수신 메시지: $messageBody")

        val command = ServiceCommand(
            gid = messageBody.gid,
            status = messageBody.status,
            completedAt = OffsetDateTime
                .parse(messageBody.completedAt)
                .toLocalDateTime(),
            data = ValidationResultCommand(
                isBlank = messageBody.payload.isBlank,
            ),
        )

        println("[ValidationService] AMQP 헤더: $messageHeader")
        saveValidationResultUseCase.saveValidationResult(command)
    }
}