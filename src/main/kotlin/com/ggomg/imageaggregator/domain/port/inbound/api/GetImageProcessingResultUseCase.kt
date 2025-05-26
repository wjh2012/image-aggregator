package com.ggomg.imageaggregator.domain.port.inbound.api

import com.ggomg.imageaggregator.domain.model.ImageProcessingResult
import java.util.UUID

interface GetImageProcessingResultUseCase {
    fun getImageProcessingResultsById(gid: UUID): ImageProcessingResult
}