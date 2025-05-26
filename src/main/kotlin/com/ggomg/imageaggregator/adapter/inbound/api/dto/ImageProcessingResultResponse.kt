package com.ggomg.imageaggregator.adapter.inbound.api.dto

data class ImageProcessingResultResponse(
    val gid: String,
    val ocrResult: OcrResultResponse,
    val validationResult: ValidationResultResponse,
    val thumbnailResult: ThumbnailResultResponse
)
