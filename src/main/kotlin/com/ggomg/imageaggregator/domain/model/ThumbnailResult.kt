package com.ggomg.imageaggregator.domain.model

data class ThumbnailResult(
    val gid: String,
    val status: String,
    val completedAt: String,
    val bucket: String,
    val thumbnailObjectKey: String
)
