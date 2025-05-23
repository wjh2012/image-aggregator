package com.ggomg.imageaggregator.adapter.inbound.messaging

import com.fasterxml.jackson.databind.ObjectMapper
import com.ggomg.imageaggregator.adapter.inbound.message.OcrServiceMessage
import com.ggomg.imageaggregator.application.port.inbound.OcrResultMessageHandler
import com.ggomg.imageaggregator.application.port.inbound.command.OcrResultCommand
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class OcrServiceConsumer(
    private val ocrMessageHandler: OcrResultMessageHandler,
    private val objectMapper: ObjectMapper
) {
    @RabbitListener(queues = ["\${services.image.ocr.queue}"])
    fun handleOcrMessage(message: String) {
        val ocrMessage = objectMapper.readValue(message, OcrServiceMessage::class.java)
        println("[OCR] 수신 메시지: $ocrMessage")

        val command = OcrResultCommand(
            gid = ocrMessage.ocrMessagePayload.gid,
            status = ocrMessage.ocrMessagePayload.status,
            completedAt = ocrMessage.ocrMessagePayload.completedAt,
            ocrResults = ocrMessage.ocrMessagePayload.ocrResults,
        )
        ocrMessageHandler.handleMessage(command)
    }
}