package com.ggomg.imageaggregator.adapter.outbound.persistence.thumbnail

import com.ggomg.imageaggregator.domain.port.outbound.ThumbnailResultSavePort
import com.ggomg.imageaggregator.domain.model.ThumbnailResult
import com.ggomg.imageaggregator.domain.port.outbound.ThumbnailResultQueryPort
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ThumbnailResultRepositoryAdapter(private val repository: ThumbnailResultRepository) :
    ThumbnailResultSavePort, ThumbnailResultQueryPort {
    override fun save(result: ThumbnailResult) {
        val entity = ThumbnailResultEntity.fromDomain(result)
        repository.save(entity)
    }

    override fun findByGid(gid: UUID): ThumbnailResult? {
        val entity = repository.findByGid(gid.toString())
            ?: throw NoSuchElementException("ThumbnailResult not found for gid=$gid")
        return ThumbnailResultEntity.toDomain(entity)
    }
}