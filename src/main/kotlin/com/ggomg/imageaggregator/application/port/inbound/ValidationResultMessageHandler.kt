package com.ggomg.imageaggregator.application.port.inbound

import com.ggomg.imageaggregator.application.port.inbound.command.ValidationResultCommand

interface ValidationResultMessageHandler {
    fun handleMessage(command: ValidationResultCommand)
}