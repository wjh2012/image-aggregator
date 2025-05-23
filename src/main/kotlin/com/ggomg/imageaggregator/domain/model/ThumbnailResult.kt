package com.ggomg.imageaggregator.domain.model

data class ThumbnailResult(
    val gid: String,
    val status: String,
    val createdAt: String,
    val bucket: String,
    val thumbnailObjectKey: String
)
