package com.ggomg.imageaggregator.adapter.out.persistence.thumbnail

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ThumbnailResultRepository : JpaRepository<ThumbnailResultEntity, UUID>