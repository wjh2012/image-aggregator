package com.ggomg.imageaggregator.domain.port.outbound

import com.ggomg.imageaggregator.domain.model.ThumbnailResult
import java.util.UUID

interface ThumbnailResultQueryPort {
    fun findByGid(gid: UUID): ThumbnailResult?
}