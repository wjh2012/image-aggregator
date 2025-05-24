package com.ggomg.imageaggregator.adapter.inbound.message

import com.fasterxml.jackson.annotation.JsonProperty

data class ValidationServiceData(
    @JsonProperty("is_blank")
    val isBlank: Boolean,
) : ServicePayload