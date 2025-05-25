package com.ggomg.imageaggregator.domain.port.outbound

import com.ggomg.imageaggregator.domain.model.ThumbnailResult

interface ThumbnailResultSavePort {
    fun save(result: ThumbnailResult)
}