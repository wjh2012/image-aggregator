package com.ggomg.imageaggregator.domain.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.ggomg.imageaggregator.adapter.`in`.dto.ValidationResultDto
import com.ggomg.imageaggregator.domain.model.ValidationResult
import com.ggomg.imageaggregator.domain.port.`in`.ValidationResultMessageHandler
import com.ggomg.imageaggregator.domain.port.out.ValidationResultSavePort
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