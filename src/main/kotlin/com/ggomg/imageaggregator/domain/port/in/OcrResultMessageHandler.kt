package com.ggomg.imageaggregator.domain.port.`in`

interface OcrResultMessageHandler {
    fun handleMessage(message: String)
}