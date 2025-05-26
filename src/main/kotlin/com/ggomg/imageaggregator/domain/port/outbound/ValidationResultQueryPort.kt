package com.ggomg.imageaggregator.domain.port.outbound

import com.ggomg.imageaggregator.domain.model.ValidationResult
import java.util.UUID

interface ValidationResultQueryPort {
    fun findByGid(gid: UUID): ValidationResult?

}