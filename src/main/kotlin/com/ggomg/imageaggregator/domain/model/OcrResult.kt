package com.ggomg.imageaggregator.domain.model

import java.time.LocalDateTime

data class OcrResult(
    val gid: String,
    val status: Status,
    val completedAt: LocalDateTime,
    val text: String
)