package com.ggomg.imageaggregator.adapter.outbound.persistence.validation

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ValidationResultRepository : JpaRepository<ValidationResultEntity, UUID>