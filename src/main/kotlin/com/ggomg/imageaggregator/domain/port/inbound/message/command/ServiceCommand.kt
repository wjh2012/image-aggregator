package com.ggomg.imageaggregator.domain.port.inbound.message.command

data class ServiceCommand<T : CommandData>(
    val gid: String,
    val status: String,
    val completedAt: String,
    val data: T,
)

interface CommandData
