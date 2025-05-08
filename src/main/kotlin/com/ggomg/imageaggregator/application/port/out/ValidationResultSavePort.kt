package com.ggomg.imageaggregator.application.port.out

import com.ggomg.imageaggregator.domain.model.ValidationResult

interface ValidationResultSavePort {
    fun save(result: ValidationResult)
}