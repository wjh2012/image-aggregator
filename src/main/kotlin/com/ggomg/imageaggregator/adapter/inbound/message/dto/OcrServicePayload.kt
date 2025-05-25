package com.ggomg.imageaggregator.adapter.inbound.message.dto

data class OcrServicePayload(
    val text: List<String>?,
) : ServicePayload