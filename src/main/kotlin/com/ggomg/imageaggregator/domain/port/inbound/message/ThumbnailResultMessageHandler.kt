package com.ggomg.imageaggregator.domain.port.inbound.message

import com.ggomg.imageaggregator.domain.port.inbound.message.command.ServiceCommand
import com.ggomg.imageaggregator.domain.port.inbound.message.command.ThumbnailResultCommand

interface ThumbnailResultMessageHandler {
    fun handleMessage(command: ServiceCommand<ThumbnailResultCommand>)
}