package com.ggomg.imageaggregator.application.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.ggomg.imageaggregator.adapter.`in`.dto.ValidationResultDto
import com.ggomg.imageaggregator.domain.model.ValidationResult
import com.ggomg.imageaggregator.application.port.`in`.ValidationResultMessageHandler
import com.ggomg.imageaggregator.application.port.out.ValidationResultSavePort
import org.springframework.stereotype.Service


@Service
class ValidationResultService(
    private val validationResultSavePort: ValidationResultSavePort,
    private val objectMapper: ObjectMapper
) : ValidationResultMessageHandler {

    override fun handleMessage(message: String) {
        val dto = objectMapper.readValue(message, ValidationResultDto::class.java)

        val result = ValidationResult(
            gid = dto.gid,
            is_blank = dto.validation_result.is_blank
        )
        validationResultSavePort.save(result)
    }
}