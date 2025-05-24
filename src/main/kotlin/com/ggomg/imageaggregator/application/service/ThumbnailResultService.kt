package com.ggomg.imageaggregator.application.service

import com.ggomg.imageaggregator.application.port.inbound.ThumbnailResultMessageHandler
import com.ggomg.imageaggregator.application.port.inbound.command.ServiceCommand
import com.ggomg.imageaggregator.application.port.inbound.command.ThumbnailResultCommand
import com.ggomg.imageaggregator.application.port.outbound.ThumbnailResultSavePort
import com.ggomg.imageaggregator.domain.model.ThumbnailResult
import org.springframework.stereotype.Service


@Service
class ThumbnailResultService(
    private val thumbnailResultSavePort: ThumbnailResultSavePort,
) : ThumbnailResultMessageHandler {
    override fun handleMessage(command: ServiceCommand<ThumbnailResultCommand>) {
        val result = ThumbnailResult(
            gid = command.gid,
            status = command.status,
            completedAt = command.completedAt,
            bucket = command.data.bucket,
            thumbnailObjectKey = command.data.thumbnailObjectKey,
        )
        thumbnailResultSavePort.save(result)
    }
}