package com.ggomg.imageaggregator.application

import com.ggomg.imageaggregator.domain.model.ImageProcessingResult
import com.ggomg.imageaggregator.domain.port.inbound.api.GetImageProcessingResultUseCase
import com.ggomg.imageaggregator.domain.port.outbound.OcrResultQueryPort
import com.ggomg.imageaggregator.domain.port.outbound.ThumbnailResultQueryPort
import com.ggomg.imageaggregator.domain.port.outbound.ValidationResultQueryPort
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class GetImageProcessingResultService(
    private val ocrResultQueryPort: OcrResultQueryPort,
    private val validationResultQueryPort: ValidationResultQueryPort,
    private val thumbnailResultQueryPort: ThumbnailResultQueryPort
) : GetImageProcessingResultUseCase {
    override fun getImageProcessingResultsById(gid: UUID): ImageProcessingResult {
        val ocrResult = ocrResultQueryPort.findByGid(gid)
        val validationResult = validationResultQueryPort.findByGid(gid)
        val thumbnailResult = thumbnailResultQueryPort.findByGid(gid)

        return ImageProcessingResult(gid.toString(), ocrResult, validationResult, thumbnailResult)
    }
}