package com.ggomg.imageaggregator.adapter.inbound.message

data class ThumbnailServiceMessage(
    val messageHeader: MessageHeader,
    val thumbnailMessagePayload: ThumbnailMessagePayload
)

data class ThumbnailMessagePayload(
    val gid: String,
    val status: String,
    val bucket: String,
    val thumbnailObjectKey: String,
    val createdAt: String,
)