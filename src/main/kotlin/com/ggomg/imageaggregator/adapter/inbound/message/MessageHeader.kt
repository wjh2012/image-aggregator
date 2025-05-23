package com.ggomg.imageaggregator.adapter.inbound.message

data class MessageHeader(
    val eventId: String,
    val eventType: String,
    val traceId: String,
    val timestamp: String,
    val sourceService: String
)
