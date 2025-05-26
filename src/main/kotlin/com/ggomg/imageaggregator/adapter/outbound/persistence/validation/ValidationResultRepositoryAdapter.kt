package com.ggomg.imageaggregator.adapter.outbound.persistence.validation

import com.ggomg.imageaggregator.domain.model.ValidationResult
import com.ggomg.imageaggregator.domain.port.outbound.ValidationResultQueryPort
import com.ggomg.imageaggregator.domain.port.outbound.ValidationResultSavePort
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ValidationResultRepositoryAdapter(
    private val repository: ValidationResultRepository
) :
    ValidationResultSavePort, ValidationResultQueryPort {
    override fun save(result: ValidationResult) {
        val entity = ValidationResultEntity.Companion.fromDomain(result)
        repository.save(entity)
    }

    override fun findByGid(gid: UUID): ValidationResult? {
        val entity = repository.findByGid(gid.toString())
            ?: throw NoSuchElementException("ValidationResult not found for gid=$gid")
        return ValidationResultEntity.toDomain(entity)
    }
}