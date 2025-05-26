package com.ggomg.imageaggregator.adapter.outbound.persistence.thumbnail

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ThumbnailResultRepository : JpaRepository<ThumbnailResultEntity, UUID> {
    fun findByGid(gid: String): ThumbnailResultEntity?
}