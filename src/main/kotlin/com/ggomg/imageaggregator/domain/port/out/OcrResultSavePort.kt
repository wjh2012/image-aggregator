package com.ggomg.imageaggregator.domain.port.out

import com.ggomg.imageaggregator.domain.model.OcrResult

interface OcrResultSavePort {
    fun save(result: OcrResult)
}