package com.ggomg.imageaggregator.adapter.inbound.message

data class ValidationServiceMessage(
    val messageHeader: MessageHeader,
    val validationMessagePayload: ValidationMessagePayload
)

data class ValidationMessagePayload(
    val gid: String,
    val status: String,
    val completedAt: String,
    val validationResults: Any?,
)