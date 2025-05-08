package com.ggomg.imageaggregator.application.port.out

import com.ggomg.imageaggregator.domain.model.OcrResult

interface OcrResultSavePort {
    fun save(result: OcrResult)
}