package com.ggomg.imageaggregator.adapter.outbound.persistence.ocr

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface OcrResultRepository : JpaRepository<OcrResultEntity, UUID> {
    fun findByGid(gid: String): OcrResultEntity?
}