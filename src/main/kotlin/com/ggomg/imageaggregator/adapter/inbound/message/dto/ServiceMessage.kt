package com.ggomg.imageaggregator.adapter.inbound.message.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class MessageHeader(
    @JsonProperty("event_id")
    val eventId: String,

    @JsonProperty("event_type")
    val eventType: String,

    @JsonProperty("trace_id")
    val traceId: String,

    @JsonProperty("timestamp")
    val timestamp: String,

    @JsonProperty("source_service")
    val sourceService: String
)

data class MessageBody<T : ServicePayload>(
    val gid: String,
    val status: String,
    @JsonProperty("completed_at")
    val completedAt: String,
    val payload: T,
)

interface ServicePayload