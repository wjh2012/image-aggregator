package com.ggomg.imageaggregator.application.port.inbound

import com.ggomg.imageaggregator.application.port.inbound.command.OcrResultCommand

interface OcrResultMessageHandler {
    fun handleMessage(command: OcrResultCommand)
}