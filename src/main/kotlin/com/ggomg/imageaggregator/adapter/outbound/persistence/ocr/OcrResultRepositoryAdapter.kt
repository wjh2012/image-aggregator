package com.ggomg.imageaggregator.adapter.outbound.persistence.ocr

import com.ggomg.imageaggregator.domain.model.OcrResult
import com.ggomg.imageaggregator.domain.port.outbound.OcrResultQueryPort
import com.ggomg.imageaggregator.domain.port.outbound.OcrResultSavePort
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class OcrResultRepositoryAdapter(private val repository: OcrResultRepository) :
    OcrResultSavePort, OcrResultQueryPort {
    override fun save(result: OcrResult) {
        val entity = OcrResultEntity.fromDomain(result)
        repository.save(entity)
    }

    override fun findByGid(gid: UUID): OcrResult? {
        val entity = repository.findByGid(gid.toString())
            ?: throw NoSuchElementException("OcrResult not found for gid=$gid")
        return OcrResultEntity.toDomain(entity)
    }
}