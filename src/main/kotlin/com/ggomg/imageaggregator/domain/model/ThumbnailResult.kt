package com.ggomg.imageaggregator.domain.model

import java.time.LocalDateTime

data class ThumbnailResult(
    val gid: String,
    val status: Status,
    val completedAt: LocalDateTime,
    val bucket: String,
    val thumbnailObjectKey: String
)
