package com.ggomg.imageaggregator.domain.port.out

import com.ggomg.imageaggregator.domain.model.ValidationResult

interface ValidationResultSavePort {
    fun save(result: ValidationResult)
}