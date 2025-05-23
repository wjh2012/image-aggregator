package com.ggomg.imageaggregator.adapter.outbound.persistence.validation

import com.fasterxml.uuid.Generators
import com.ggomg.imageaggregator.adapter.outbound.persistence.BaseEntity
import com.ggomg.imageaggregator.domain.model.ValidationResult
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "validation_results")
class ValidationResultEntity(

    @Id
    var id: UUID? = null,

    var gid: String? = null,

    var is_blank: Boolean? = null

) : BaseEntity() {
    companion object {
        fun from(domain: ValidationResult): ValidationResultEntity = ValidationResultEntity(
            id = Generators.timeBasedEpochGenerator().generate(),
            gid = domain.gid,
            is_blank = domain.is_blank
        )
    }
}