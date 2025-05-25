package com.ggomg.imageaggregator.adapter.outbound.persistence.validation

import com.ggomg.imageaggregator.domain.model.ValidationResult
import com.ggomg.imageaggregator.domain.port.outbound.ValidationResultSavePort
import org.springframework.stereotype.Component

@Component
class ValidationResultResultRepositoryAdapter(private val repository: ValidationResultRepository) :
    ValidationResultSavePort {
    override fun save(result: ValidationResult) {
        val entity = ValidationResultEntity.Companion.from(result)
        repository.save(entity)
    }
}