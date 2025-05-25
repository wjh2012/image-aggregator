package com.ggomg.imageaggregator.adapter.inbound.message.dto

data class OcrServiceData(
    val text: List<String>?,
) : ServicePayload