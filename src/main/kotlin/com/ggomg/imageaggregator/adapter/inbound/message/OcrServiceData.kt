package com.ggomg.imageaggregator.adapter.inbound.message

data class OcrServiceData(
    val text: List<String>?,
) : ServicePayload