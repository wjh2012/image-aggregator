package com.ggomg.imageaggregator.adapter.inbound.messaging

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.ggomg.imageaggregator.adapter.inbound.message.MessageHeader
import com.ggomg.imageaggregator.adapter.inbound.message.MessageBody
import com.ggomg.imageaggregator.adapter.inbound.message.OcrServiceData
import com.ggomg.imageaggregator.application.port.inbound.OcrResultMessageHandler
import com.ggomg.imageaggregator.application.port.inbound.command.OcrResultCommand
import com.ggomg.imageaggregator.application.port.inbound.command.ServiceCommand
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.stereotype.Component

@Component
class OcrServiceConsumer(
    private val ocrMessageHandler: OcrResultMessageHandler,
    private val objectMapper: ObjectMapper
) {
    @RabbitListener(queues = ["\${services.image.ocr.queue}"])
    fun handleOcrMessage(
        @Headers headers: Map<String, Any>,
        body: String
    ) {
        val messageHeader = objectMapper.convertValue(headers, MessageHeader::class.java)
        val messageBody: MessageBody<OcrServiceData> = objectMapper.readValue(
            body,
            object : TypeReference<MessageBody<OcrServiceData>>() {}
        )
        println("[OCR] 수신 메시지: $messageBody")

        val command = ServiceCommand(
            gid = messageBody.gid,
            status = messageBody.status,
            completedAt = messageBody.completedAt,
            data = OcrResultCommand(text = messageBody.payload.text),
        )
        println("[OCR] AMQP 헤더: $messageHeader")
        ocrMessageHandler.handleMessage(command)
    }
}