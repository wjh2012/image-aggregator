package com.ggomg.imageaggregator.adapter.inbound.message.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ValidationServicePayload(
    @JsonProperty("is_blank")
    val isBlank: Boolean,
) : ServicePayload