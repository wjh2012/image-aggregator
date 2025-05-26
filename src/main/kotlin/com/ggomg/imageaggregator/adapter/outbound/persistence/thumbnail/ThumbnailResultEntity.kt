package com.ggomg.imageaggregator.adapter.outbound.persistence.thumbnail

import com.fasterxml.uuid.Generators
import com.ggomg.imageaggregator.adapter.outbound.persistence.BaseEntity
import com.ggomg.imageaggregator.adapter.outbound.persistence.EntityStatus
import com.ggomg.imageaggregator.domain.model.Status
import com.ggomg.imageaggregator.domain.model.ThumbnailResult
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "thumbnail_results")
class ThumbnailResultEntity(

    @Id
    var id: UUID? = null,

    var gid: String? = null,

    @Enumerated(EnumType.STRING)
    var status: EntityStatus? = null,

    var completedAt: LocalDateTime? = null,

    var bucket: String? = null,

    var thumbnailObjectKey: String? = null

) : BaseEntity() {
    companion object {
        fun fromDomain(domain: ThumbnailResult): ThumbnailResultEntity = ThumbnailResultEntity(
            id = Generators.timeBasedEpochGenerator().generate(),
            gid = domain.gid,
            status = EntityStatus.valueOf(domain.status.name),
            completedAt = domain.completedAt,
            bucket = domain.bucket,
            thumbnailObjectKey = domain.thumbnailObjectKey
        )

        fun toDomain(entity: ThumbnailResultEntity): ThumbnailResult = ThumbnailResult(
            gid = entity.gid ?: throw IllegalArgumentException("gid is null"),
            status = Status.valueOf(
                entity.status?.name ?: throw IllegalArgumentException("status is null")
            ),
            completedAt = entity.completedAt
                ?: throw IllegalArgumentException("completedAt is null"),
            bucket = entity.bucket ?: throw IllegalArgumentException("bucket is null"),
            thumbnailObjectKey = entity.thumbnailObjectKey
                ?: throw IllegalArgumentException("thumbnailObjectKey is null"),
        )
    }
}