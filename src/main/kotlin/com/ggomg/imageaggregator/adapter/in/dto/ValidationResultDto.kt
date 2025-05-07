package com.ggomg.imageaggregator.adapter.`in`.dto

data class ValidationResultDto(
    val gid: String,
    val status: String,
    val created_time: String,
    val validation_result: ValidationResultDetailDto
)

data class ValidationResultDetailDto(
    val is_blank: Boolean
)