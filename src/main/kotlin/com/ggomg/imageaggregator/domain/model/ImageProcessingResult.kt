package com.ggomg.imageaggregator.domain.model

data class ImageProcessingResult(
    val gid: String,
    var ocrResult: OcrResult? = null,
    var validationResult: ValidationResult? = null,
    var thumbnailResult: ThumbnailResult? = null
) {
    fun applyOcrResult(result: OcrResult) {
        this.ocrResult = result
    }

    fun applyValidationResult(result: ValidationResult) {
        this.validationResult = result
    }

    fun applyThumbnailResult(result: ThumbnailResult) {
        this.thumbnailResult = result
    }
}
