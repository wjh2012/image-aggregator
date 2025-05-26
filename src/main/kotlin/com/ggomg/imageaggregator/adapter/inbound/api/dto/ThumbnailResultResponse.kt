package com.ggomg.imageaggregator.adapter.inbound.api.dto

import com.ggomg.imageaggregator.domain.model.ThumbnailResult
import java.time.LocalDateTime

data class ThumbnailResultResponse(
    val status: ResponseStatus,
    val completedAt: LocalDateTime,
    val bucket: String,
    val thumbnailObjectKey: String
) {
    companion object {
        fun fromDomain(domain: ThumbnailResult): ThumbnailResultResponse {
            return ThumbnailResultResponse(
                status = ResponseStatus.valueOf(domain.status.name),
                completedAt = domain.completedAt,
                bucket = domain.bucket,
                thumbnailObjectKey = domain.thumbnailObjectKey
            )
        }
    }
}
