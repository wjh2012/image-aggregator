package com.ggomg.imageaggregator.adapter.`in`.messaging

import com.ggomg.imageaggregator.application.port.`in`.ThumbnailResultMessageHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class ThumbnailConsumer(
    private val thumbnailResultMessageHandler: ThumbnailResultMessageHandler,
) {

    @RabbitListener(queues = ["\${services.image.thumbnail.queue}"])
    fun handleValidationMessage(message: String) {
        println("[Thumbnail] 수신 메시지: $message")
        thumbnailResultMessageHandler.handleMessage(message)
    }
}