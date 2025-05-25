package com.ggomg.imageaggregator.domain.port.inbound.message.command

data class OcrResultCommand(
    val text: List<String>?
) : CommandData
