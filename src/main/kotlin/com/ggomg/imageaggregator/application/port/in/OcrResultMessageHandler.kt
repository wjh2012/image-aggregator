package com.ggomg.imageaggregator.application.port.`in`

interface OcrResultMessageHandler {
    fun handleMessage(message: String)
}