package com.ggomg.imageaggregator.adapter.out.persistence.validation

import com.ggomg.imageaggregator.domain.model.ValidationResult
import com.ggomg.imageaggregator.application.port.out.ValidationResultSavePort
import org.springframework.stereotype.Component

@Component
class ValidationResultResultRepositoryAdapter(private val repository: ValidationResultRepository) :
    ValidationResultSavePort {
    override fun save(result: ValidationResult) {
        val entity = ValidationResultEntity.Companion.from(result)
        repository.save(entity)
    }
}