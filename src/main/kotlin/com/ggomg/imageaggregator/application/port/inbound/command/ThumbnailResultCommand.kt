package com.ggomg.imageaggregator.application.port.inbound.command

data class ThumbnailResultCommand(
    val gid: String,
    val status: String,
    val bucket: String,
    val thumbnailObjectKey: String,
    val createdAt: String,
)
