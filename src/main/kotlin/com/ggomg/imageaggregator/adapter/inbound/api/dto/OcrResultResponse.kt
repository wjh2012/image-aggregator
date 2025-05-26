package com.ggomg.imageaggregator.adapter.inbound.api.dto

import com.ggomg.imageaggregator.domain.model.OcrResult
import java.time.LocalDateTime

data class OcrResultResponse(
    val status: ResponseStatus,
    val completedAt: LocalDateTime,
    val text: String
) {
    companion object {
        fun fromDomain(domain: OcrResult): OcrResultResponse {
            return OcrResultResponse(
                status = ResponseStatus.valueOf(domain.status.name),
                completedAt = domain.completedAt,
                text = domain.text
            )
        }
    }
}