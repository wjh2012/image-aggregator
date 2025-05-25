package com.ggomg.imageaggregator.adapter.inbound.message.consumer

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.ggomg.imageaggregator.adapter.inbound.message.dto.MessageHeader
import com.ggomg.imageaggregator.adapter.inbound.message.dto.MessageBody
import com.ggomg.imageaggregator.adapter.inbound.message.dto.OcrServicePayload
import com.ggomg.imageaggregator.domain.port.inbound.message.SaveOcrResultUseCase
import com.ggomg.imageaggregator.domain.port.inbound.message.command.OcrResultCommand
import com.ggomg.imageaggregator.domain.port.inbound.message.command.ServiceCommand
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.stereotype.Component

@Component
class OcrServiceConsumer(
    private val ocrMessageHandler: SaveOcrResultUseCase,
    private val objectMapper: ObjectMapper
) {
    @RabbitListener(queues = ["\${services.image.ocr.queue}"])
    fun handleOcrMessage(
        @Headers headers: Map<String, Any>,
        body: String
    ) {
        val messageHeader = objectMapper.convertValue(headers, MessageHeader::class.java)
        val messageBody: MessageBody<OcrServicePayload> = objectMapper.readValue(
            body,
            object : TypeReference<MessageBody<OcrServicePayload>>() {}
        )
        println("[OCR] 수신 메시지: $messageBody")

        val command = ServiceCommand(
            gid = messageBody.gid,
            status = messageBody.status,
            completedAt = messageBody.completedAt,
            data = OcrResultCommand(text = messageBody.payload.text),
        )
        println("[OCR] AMQP 헤더: $messageHeader")
        ocrMessageHandler.saveOcrResult(command)
    }
}