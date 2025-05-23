package com.ggomg.imageaggregator.adapter.inbound.messaging

import com.fasterxml.jackson.databind.ObjectMapper
import com.ggomg.imageaggregator.adapter.inbound.message.ThumbnailServiceMessage
import com.ggomg.imageaggregator.application.port.inbound.ThumbnailResultMessageHandler
import com.ggomg.imageaggregator.application.port.inbound.command.ThumbnailResultCommand
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class ThumbnailServiceConsumer(
    private val thumbnailResultMessageHandler: ThumbnailResultMessageHandler,
    private val objectMapper: ObjectMapper
) {
    @RabbitListener(queues = ["\${services.image.thumbnail.queue}"])
    fun handleOcrMessage(message: String) {
        val thumbnailMessage = objectMapper.readValue(message, ThumbnailServiceMessage::class.java)
        println("[ThumbnailService] 수신 메시지: $thumbnailMessage")

        val command = ThumbnailResultCommand(
            gid = thumbnailMessage.thumbnailMessagePayload.gid,
            status = thumbnailMessage.thumbnailMessagePayload.status,
            bucket = thumbnailMessage.thumbnailMessagePayload.bucket,
            thumbnailObjectKey = thumbnailMessage.thumbnailMessagePayload.thumbnailObjectKey,
            createdAt = thumbnailMessage.thumbnailMessagePayload.createdAt,
        )

        thumbnailResultMessageHandler.handleMessage(command)
    }
}