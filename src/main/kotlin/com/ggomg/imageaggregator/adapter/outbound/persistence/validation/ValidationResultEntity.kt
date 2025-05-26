package com.ggomg.imageaggregator.adapter.outbound.persistence.validation

import com.fasterxml.uuid.Generators
import com.ggomg.imageaggregator.adapter.outbound.persistence.BaseEntity
import com.ggomg.imageaggregator.adapter.outbound.persistence.EntityStatus
import com.ggomg.imageaggregator.domain.model.Status
import com.ggomg.imageaggregator.domain.model.ValidationResult
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "validation_results")
class ValidationResultEntity(

    @Id
    var id: UUID? = null,

    var gid: String? = null,

    @Enumerated(EnumType.STRING)
    var status: EntityStatus? = null,

    var completedAt: LocalDateTime? = null,

    var isBlank: Boolean? = null

) : BaseEntity() {
    companion object {
        fun fromDomain(domain: ValidationResult): ValidationResultEntity = ValidationResultEntity(
            id = Generators.timeBasedEpochGenerator().generate(),
            gid = domain.gid,
            status = EntityStatus.valueOf(domain.status.name),
            completedAt = domain.completedAt,
            isBlank = domain.isBlank
        )

        fun toDomain(entity: ValidationResultEntity): ValidationResult = ValidationResult(
            gid = entity.gid ?: throw IllegalArgumentException("gid is null"),
            status = Status.valueOf(
                entity.status?.name ?: throw IllegalArgumentException("status is null")
            ),
            completedAt = entity.completedAt
                ?: throw IllegalArgumentException("completedAt is null"),
            isBlank = entity.isBlank ?: throw IllegalArgumentException("isBlank is null"),
        )
    }
}