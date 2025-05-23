package com.ggomg.imageaggregator.application.port.outbound

import com.ggomg.imageaggregator.domain.model.OcrResult

interface OcrResultSavePort {
    fun save(result: OcrResult)
}