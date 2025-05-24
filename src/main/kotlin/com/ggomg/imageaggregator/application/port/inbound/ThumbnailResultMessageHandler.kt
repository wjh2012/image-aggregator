package com.ggomg.imageaggregator.application.port.inbound

import com.ggomg.imageaggregator.application.port.inbound.command.ServiceCommand
import com.ggomg.imageaggregator.application.port.inbound.command.ThumbnailResultCommand

interface ThumbnailResultMessageHandler {
    fun handleMessage(command: ServiceCommand<ThumbnailResultCommand>)
}