package com.ggomg.imageaggregator.domain.port.inbound.message

import com.ggomg.imageaggregator.domain.port.inbound.message.command.ServiceCommand
import com.ggomg.imageaggregator.domain.port.inbound.message.command.ThumbnailResultCommand

interface SaveThumbnailResultUseCase {
    fun saveThumbnailResult(command: ServiceCommand<ThumbnailResultCommand>)
}