package com.ggomg.imageaggregator.adapter.`in`.messaging

import com.ggomg.imageaggregator.application.port.`in`.OcrResultMessageHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class OcrResultConsumer(
    private val ocrMessageHandler: OcrResultMessageHandler,
) {

    @RabbitListener(queues = ["\${services.image.ocr.queue}"])
    fun handleOcrMessage(message: String) {
        println("[OCR] 수신 메시지: $message")
        ocrMessageHandler.handleMessage(message)
    }

}