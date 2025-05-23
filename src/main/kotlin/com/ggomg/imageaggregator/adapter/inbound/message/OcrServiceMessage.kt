package com.ggomg.imageaggregator.adapter.inbound.message

data class OcrServiceMessage(
    val messageHeader: MessageHeader,
    val ocrMessagePayload: OcrMessagePayload,
)

data class OcrMessagePayload(
    val gid: String,
    val status: String,
    val completedAt: String,
    val ocrResults: List<String>?,
)