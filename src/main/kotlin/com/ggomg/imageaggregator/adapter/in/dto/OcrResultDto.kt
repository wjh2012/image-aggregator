package com.ggomg.imageaggregator.adapter.`in`.dto

data class OcrResultDto(
    val gid: String,
    val status: String,
    val ocr_result: List<String>?,
    val created_time: String
)