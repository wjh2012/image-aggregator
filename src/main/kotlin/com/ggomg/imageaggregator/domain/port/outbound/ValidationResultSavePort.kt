package com.ggomg.imageaggregator.domain.port.outbound

import com.ggomg.imageaggregator.domain.model.ValidationResult

interface ValidationResultSavePort {
    fun save(result: ValidationResult)
}