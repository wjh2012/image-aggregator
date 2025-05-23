package com.ggomg.imageaggregator.adapter.outbound.persistence.thumbnail

import com.ggomg.imageaggregator.application.port.outbound.ThumbnailResultSavePort
import com.ggomg.imageaggregator.domain.model.ThumbnailResult
import org.springframework.stereotype.Component

@Component
class ThumbnailResultRepositoryAdapter(private val repository: ThumbnailResultRepository) :
    ThumbnailResultSavePort {
    override fun save(result: ThumbnailResult) {
        val entity = ThumbnailResultEntity.from(result)
        repository.save(entity)
    }
}