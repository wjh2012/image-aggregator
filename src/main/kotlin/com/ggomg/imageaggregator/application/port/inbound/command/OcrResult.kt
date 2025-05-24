package com.ggomg.imageaggregator.application.port.inbound.command

data class OcrResultCommand(
    val text: List<String>?
) : CommandData
