package com.ggomg.imageaggregator.domain.model

data class OcrResult(
    val gid: String,
    val status: String,
    val completedAt: String,
    val text: String
)