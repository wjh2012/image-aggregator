package com.ggomg.imageaggregator.application.port.inbound.command

data class ServiceCommand<T : CommandData>(
    val gid: String,
    val status: String,
    val completedAt: String,
    val data: T,
)

interface CommandData
