package com.ggomg.imageaggregator.adapter.inbound.messaging

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.ggomg.imageaggregator.adapter.inbound.message.MessageBody
import com.ggomg.imageaggregator.adapter.inbound.message.MessageHeader
import com.ggomg.imageaggregator.adapter.inbound.message.ThumbnailServiceData
import com.ggomg.imageaggregator.application.port.inbound.ThumbnailResultMessageHandler
import com.ggomg.imageaggregator.application.port.inbound.command.ServiceCommand
import com.ggomg.imageaggregator.application.port.inbound.command.ThumbnailResultCommand
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.stereotype.Component

@Component
class ThumbnailServiceConsumer(
    private val thumbnailResultMessageHandler: ThumbnailResultMessageHandler,
    private val objectMapper: ObjectMapper
) {
    @RabbitListener(queues = ["\${services.image.thumbnail.queue}"])
    fun handleOcrMessage(
        @Headers headers: Map<String, Any>,
        body: String
    ) {
        val messageHeader = objectMapper.convertValue(headers, MessageHeader::class.java)
        val messageBody: MessageBody<ThumbnailServiceData> = objectMapper.readValue(
            body,
            object : TypeReference<MessageBody<ThumbnailServiceData>>() {}
        )
        println("[ThumbnailService] 수신 메시지: $messageBody")

        val command = ServiceCommand(
            gid = messageBody.gid,
            status = messageBody.status,
            completedAt = messageBody.completedAt,
            data = ThumbnailResultCommand(
                bucket = messageBody.payload.bucket,
                thumbnailObjectKey = messageBody.payload.thumbnailObjectKey
            ),
        )

        println("[ThumbnailService] AMQP 헤더: $messageHeader")
        thumbnailResultMessageHandler.handleMessage(command)
    }
}