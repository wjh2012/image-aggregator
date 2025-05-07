package com.ggomg.imageaggregator.adapter.out.persistence.ocr

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface OcrResultRepository : JpaRepository<OcrResultEntity, UUID>