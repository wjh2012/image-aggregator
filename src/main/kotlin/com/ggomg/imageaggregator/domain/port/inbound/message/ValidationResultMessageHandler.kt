package com.ggomg.imageaggregator.domain.port.inbound.message

import com.ggomg.imageaggregator.domain.port.inbound.message.command.ServiceCommand
import com.ggomg.imageaggregator.domain.port.inbound.message.command.ValidationResultCommand

interface ValidationResultMessageHandler {
    fun handleMessage(command: ServiceCommand<ValidationResultCommand>)
}