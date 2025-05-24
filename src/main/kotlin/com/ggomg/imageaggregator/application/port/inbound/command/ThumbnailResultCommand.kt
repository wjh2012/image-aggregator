package com.ggomg.imageaggregator.application.port.inbound.command

data class ThumbnailResultCommand(
    val bucket: String,
    val thumbnailObjectKey: String,
) : CommandData
