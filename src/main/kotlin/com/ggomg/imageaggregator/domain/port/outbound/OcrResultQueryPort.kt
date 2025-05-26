package com.ggomg.imageaggregator.domain.port.outbound

import com.ggomg.imageaggregator.domain.model.OcrResult
import java.util.UUID

interface OcrResultQueryPort {
    fun findByGid(gid: UUID): OcrResult?
}