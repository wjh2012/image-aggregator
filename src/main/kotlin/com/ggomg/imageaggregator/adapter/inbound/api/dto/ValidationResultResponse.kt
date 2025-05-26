package com.ggomg.imageaggregator.adapter.inbound.api.dto

import com.ggomg.imageaggregator.domain.model.ValidationResult
import java.time.LocalDateTime

data class ValidationResultResponse(
    val status: ResponseStatus,
    val completedAt: LocalDateTime,
    val isBlank: Boolean,
) {
    companion object {
        fun fromDomain(domain: ValidationResult): ValidationResultResponse {
            return ValidationResultResponse(
                status = ResponseStatus.valueOf(domain.status.name),
                completedAt = domain.completedAt,
                isBlank = domain.isBlank,
            )
        }
    }
}
