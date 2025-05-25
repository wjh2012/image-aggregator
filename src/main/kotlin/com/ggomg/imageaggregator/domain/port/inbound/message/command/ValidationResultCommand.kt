package com.ggomg.imageaggregator.domain.port.inbound.message.command

data class ValidationResultCommand(
    val isBlank: Boolean,
) : CommandData
