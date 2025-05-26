package com.ggomg.imageaggregator.adapter.outbound.persistence.ocr

import com.fasterxml.uuid.Generators
import com.ggomg.imageaggregator.adapter.outbound.persistence.BaseEntity
import com.ggomg.imageaggregator.adapter.outbound.persistence.EntityStatus
import com.ggomg.imageaggregator.domain.model.OcrResult
import com.ggomg.imageaggregator.domain.model.Status
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "ocr_results")
class OcrResultEntity(

    @Id
    var id: UUID? = null,

    var gid: String? = null,

    @Enumerated(EnumType.STRING)
    var status: EntityStatus? = null,

    var completedAt: LocalDateTime? = null,

    var text: String? = null

) : BaseEntity() {
    companion object {
        fun fromDomain(domain: OcrResult): OcrResultEntity = OcrResultEntity(
            id = Generators.timeBasedEpochGenerator().generate(),
            gid = domain.gid,
            status = EntityStatus.valueOf(domain.status.name),
            completedAt = domain.completedAt,
            text = domain.text
        )

        fun toDomain(entity: OcrResultEntity): OcrResult = OcrResult(
            gid = entity.gid ?: throw IllegalArgumentException("gid is null"),
            status = Status.valueOf(
                entity.status?.name ?: throw IllegalArgumentException("status is null")
            ),
            completedAt = entity.completedAt
                ?: throw IllegalArgumentException("completedAt is null"),
            text = entity.text ?: ""
        )
    }
}