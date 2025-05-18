package com.ggomg.imageaggregator.application.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.ggomg.imageaggregator.adapter.`in`.dto.ThumbnailResultDto
import com.ggomg.imageaggregator.application.port.`in`.ThumbnailResultMessageHandler
import com.ggomg.imageaggregator.application.port.out.ThumbnailResultSavePort
import com.ggomg.imageaggregator.domain.model.ThumbnailResult
import org.springframework.stereotype.Service


@Service
class ThumbnailResultService(
    private val thumbnailResultSavePort: ThumbnailResultSavePort,
    private val objectMapper: ObjectMapper
) : ThumbnailResultMessageHandler {

    override fun handleMessage(message: String) {
        val dto = objectMapper.readValue(message, ThumbnailResultDto::class.java)

        val result = ThumbnailResult(
            gid = dto.gid,
            thumbnailCreated = dto.thumbnailCreated
        )
        thumbnailResultSavePort.save(result)
    }
}