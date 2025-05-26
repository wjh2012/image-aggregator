package com.ggomg.imageaggregator.domain.port.inbound.message.command

import java.time.LocalDateTime

data class ServiceCommand<T : CommandData>(
    val gid: String,
    val status: String,
    val completedAt: LocalDateTime,
    val data: T,
)

interface CommandData
