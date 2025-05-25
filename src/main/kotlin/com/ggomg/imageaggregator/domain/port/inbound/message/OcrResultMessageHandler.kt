package com.ggomg.imageaggregator.domain.port.inbound.message

import com.ggomg.imageaggregator.domain.port.inbound.message.command.OcrResultCommand
import com.ggomg.imageaggregator.domain.port.inbound.message.command.ServiceCommand

interface OcrResultMessageHandler {
    fun handleMessage(command: ServiceCommand<OcrResultCommand>)
}