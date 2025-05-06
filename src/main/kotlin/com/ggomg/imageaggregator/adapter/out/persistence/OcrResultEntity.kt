package com.ggomg.imageaggregator.adapter.out.persistence

import com.fasterxml.uuid.Generators
import com.ggomg.imageaggregator.domain.model.OcrResult
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "ocr_results")
class OcrResultEntity(

    @Id
    var id: UUID? = null,

    var gid: String? = null,

    var text: String? = null

) : BaseEntity() {
    companion object {
        fun from(domain: OcrResult): OcrResultEntity = OcrResultEntity(
            id = Generators.timeBasedEpochGenerator().generate(),
            gid = domain.gid,
            text = domain.text
        )
    }
}