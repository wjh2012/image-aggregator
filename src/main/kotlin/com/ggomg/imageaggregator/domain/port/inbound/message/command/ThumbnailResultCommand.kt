package com.ggomg.imageaggregator.domain.port.inbound.message.command

data class ThumbnailResultCommand(
    val bucket: String,
    val thumbnailObjectKey: String,
) : CommandData
