package com.ggomg.imageaggregator.domain.port.outbound

import com.ggomg.imageaggregator.domain.model.OcrResult

interface OcrResultSavePort {
    fun save(result: OcrResult)
}