package com.ggomg.imageaggregator.adapter.inbound.api.controller

import com.ggomg.imageaggregator.adapter.inbound.api.dto.ImageProcessingResultResponse
import com.ggomg.imageaggregator.adapter.inbound.api.dto.OcrResultResponse
import com.ggomg.imageaggregator.adapter.inbound.api.dto.ThumbnailResultResponse
import com.ggomg.imageaggregator.adapter.inbound.api.dto.ValidationResultResponse
import com.ggomg.imageaggregator.domain.port.inbound.api.GetImageProcessingResultUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Tag(name = "ImageResult", description = "이미지 처리 결과 API")
@RestController
@RequestMapping("/results")
class ImageProcessingResultController(
    private val service: GetImageProcessingResultUseCase
) {
    @Operation(
        summary = "이미지 처리 결과 조회",
        description = "검증, OCR, 썸네일 처리 결과 조회"
    )
    @GetMapping("/{gid}")
    fun getImageProcessResults(
        @PathVariable gid: UUID
    ): ResponseEntity<ImageProcessingResultResponse> {
        val result = service.getImageProcessingResultsById(gid)

        val ocr = result.ocrResult
            ?: throw ResponseStatusException(
                HttpStatus.NOT_FOUND, "OCR 결과가 존재하지 않습니다."
            ) as Throwable
        val validation = result.validationResult
            ?: throw ResponseStatusException(
                HttpStatus.NOT_FOUND, "검증 결과가 존재하지 않습니다."
            )
        val thumbnail = result.thumbnailResult
            ?: throw ResponseStatusException(
                HttpStatus.NOT_FOUND, "썸네일 결과가 존재하지 않습니다."
            )

        val dto = ImageProcessingResultResponse(
            gid = gid.toString(),
            ocrResult = OcrResultResponse.fromDomain(ocr),
            validationResult = ValidationResultResponse.fromDomain(validation),
            thumbnailResult = ThumbnailResultResponse.fromDomain(thumbnail)
        )

        return ResponseEntity.ok(dto)
    }
}