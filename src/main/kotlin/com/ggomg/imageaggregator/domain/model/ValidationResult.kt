package com.ggomg.imageaggregator.domain.model

data class ValidationResult(
    val gid: String,
    val status: String,
    val completedAt: String,
    val isBlank: Boolean,
)
