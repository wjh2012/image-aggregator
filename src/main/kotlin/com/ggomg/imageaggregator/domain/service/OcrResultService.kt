package com.ggomg.imageaggregator.domain.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.ggomg.imageaggregator.adapter.`in`.messaging.OcrResultDto
import com.ggomg.imageaggregator.domain.model.OcrResult
import com.ggomg.imageaggregator.domain.port.`in`.OcrResultMessageHandler
import com.ggomg.imageaggregator.domain.port.out.OcrResultSavePort
import org.springframework.stereotype.Service


@Service
class OcrResultService(
    private val ocrResultSavePort: OcrResultSavePort,
    private val objectMapper: ObjectMapper
) : OcrResultMessageHandler {

    override fun handleMessage(message: String) {
        val dto = objectMapper.readValue(message, OcrResultDto::class.java)

        val result = OcrResult(
            gid = dto.gid,
            text = dto.ocr_result?.joinToString("\n") ?: ""
        )
        ocrResultSavePort.save(result)
    }
}