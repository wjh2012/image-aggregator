package com.ggomg.imageaggregator.message

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class OcrConsumer {

    @RabbitListener(queues = ["\${services.image.ocr.queue}"])
    fun handleOcrMessage(message: String) {
        println("[OCR] 수신 메시지: $message")
    }

}