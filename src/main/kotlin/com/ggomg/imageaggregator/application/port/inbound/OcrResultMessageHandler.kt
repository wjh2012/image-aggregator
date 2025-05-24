package com.ggomg.imageaggregator.application.port.inbound

import com.ggomg.imageaggregator.application.port.inbound.command.OcrResultCommand
import com.ggomg.imageaggregator.application.port.inbound.command.ServiceCommand

interface OcrResultMessageHandler {
    fun handleMessage(command: ServiceCommand<OcrResultCommand>)
}