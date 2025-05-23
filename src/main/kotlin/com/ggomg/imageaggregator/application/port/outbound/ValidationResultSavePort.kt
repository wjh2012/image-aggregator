package com.ggomg.imageaggregator.application.port.outbound

import com.ggomg.imageaggregator.domain.model.ValidationResult

interface ValidationResultSavePort {
    fun save(result: ValidationResult)
}