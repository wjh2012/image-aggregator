package com.ggomg.imageaggregator.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface OcrResultRepository : JpaRepository<OcrResultEntity, UUID>