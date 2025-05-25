package com.ggomg.imageaggregator.application

import com.ggomg.imageaggregator.domain.port.inbound.message.SaveThumbnailResultUseCase
import com.ggomg.imageaggregator.domain.port.inbound.message.command.ServiceCommand
import com.ggomg.imageaggregator.domain.port.inbound.message.command.ThumbnailResultCommand
import com.ggomg.imageaggregator.domain.port.outbound.ThumbnailResultSavePort
import com.ggomg.imageaggregator.domain.model.ThumbnailResult
import org.springframework.stereotype.Service


@Service
class SaveThumbnailResultService(
    private val thumbnailResultSavePort: ThumbnailResultSavePort,
) : SaveThumbnailResultUseCase {
    override fun saveThumbnailResult(command: ServiceCommand<ThumbnailResultCommand>) {
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