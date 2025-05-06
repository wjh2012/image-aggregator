package com.ggomg.imageaggregator.adapter.out.persistence

import com.ggomg.imageaggregator.domain.model.OcrResult
import com.ggomg.imageaggregator.domain.port.out.OcrResultSavePort
import org.springframework.stereotype.Component

@Component
class OcrResultResultRepositoryAdapter(private val repository: OcrResultRepository) :
    OcrResultSavePort {
    override fun save(result: OcrResult) {
        val entity = OcrResultEntity.from(result)
        repository.save(entity)
    }
}