package com.ggomg.imageaggregator.application.service

import com.ggomg.imageaggregator.application.port.inbound.ThumbnailResultMessageHandler
import com.ggomg.imageaggregator.application.port.inbound.command.ThumbnailResultCommand
import com.ggomg.imageaggregator.application.port.outbound.ThumbnailResultSavePort
import com.ggomg.imageaggregator.domain.model.ThumbnailResult
import org.springframework.stereotype.Service


@Service
class ThumbnailResultService(
    private val thumbnailResultSavePort: ThumbnailResultSavePort,
) : ThumbnailResultMessageHandler {
    override fun handleMessage(command: ThumbnailResultCommand) {
        val result = ThumbnailResult(
            gid = command.gid,
            status = command.status,
            createdAt = command.createdAt,
            bucket = command.bucket,
            thumbnailObjectKey = command.thumbnailObjectKey,
        )
        thumbnailResultSavePort.save(result)
    }
}