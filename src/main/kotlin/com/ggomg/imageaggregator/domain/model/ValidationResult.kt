package com.ggomg.imageaggregator.domain.model

import java.time.LocalDateTime

data class ValidationResult(
    val gid: String,
    val status: Status,
    val completedAt: LocalDateTime,
    val isBlank: Boolean,
)
