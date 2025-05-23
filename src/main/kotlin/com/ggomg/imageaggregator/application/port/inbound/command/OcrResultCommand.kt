package com.ggomg.imageaggregator.application.port.inbound.command

data class OcrResultCommand(
    val gid: String,
    val status: String,
    val completedAt: String,
    val ocrResults: List<String>?
)
