package com.ggomg.imageaggregator.application.port.outbound

import com.ggomg.imageaggregator.domain.model.ThumbnailResult

interface ThumbnailResultSavePort {
    fun save(result: ThumbnailResult)
}