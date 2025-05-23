package com.ggomg.imageaggregator.adapter.outbound.persistence.thumbnail

import com.fasterxml.uuid.Generators
import com.ggomg.imageaggregator.adapter.outbound.persistence.BaseEntity
import com.ggomg.imageaggregator.domain.model.ThumbnailResult
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "thumbnail_results")
class ThumbnailResultEntity(

    @Id
    var id: UUID? = null,

    var gid: String? = null,

    var thumbnailCreated: Boolean = false

) : BaseEntity() {
    companion object {
        fun from(domain: ThumbnailResult): ThumbnailResultEntity = ThumbnailResultEntity(
            id = Generators.timeBasedEpochGenerator().generate(),
            gid = domain.gid,
            thumbnailCreated = domain.thumbnailCreated
        )
    }
}