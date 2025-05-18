package com.ggomg.imageaggregator.application.port.out

import com.ggomg.imageaggregator.domain.model.ThumbnailResult

interface ThumbnailResultSavePort {
    fun save(result: ThumbnailResult)
}