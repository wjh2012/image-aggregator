package com.ggomg.imageaggregator.application.port.inbound.command

data class ValidationResultCommand(
    val gid: String,
    val status: String,
    val completedAt: String,
    val validationResults: Any?,
)
