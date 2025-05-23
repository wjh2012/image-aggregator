package com.ggomg.imageaggregator.adapter.outbound.persistence.ocr

import com.ggomg.imageaggregator.domain.model.OcrResult
import com.ggomg.imageaggregator.application.port.outbound.OcrResultSavePort
import org.springframework.stereotype.Component

@Component
class OcrResultRepositoryAdapter(private val repository: OcrResultRepository) :
    OcrResultSavePort {
    override fun save(result: OcrResult) {
        val entity = OcrResultEntity.from(result)
        repository.save(entity)
    }
}