package com.ggomg.imageaggregator.application.service

import com.ggomg.imageaggregator.domain.model.ValidationResult
import com.ggomg.imageaggregator.application.port.inbound.ValidationResultMessageHandler
import com.ggomg.imageaggregator.application.port.inbound.command.ServiceCommand
import com.ggomg.imageaggregator.application.port.inbound.command.ValidationResultCommand
import com.ggomg.imageaggregator.application.port.outbound.ValidationResultSavePort
import org.springframework.stereotype.Service


@Service
class ValidationResultService(
    private val validationResultSavePort: ValidationResultSavePort,
) : ValidationResultMessageHandler {
    override fun handleMessage(command: ServiceCommand<ValidationResultCommand>) {
        val result = ValidationResult(
            gid = command.gid,
            status = command.status,
            completedAt = command.completedAt,
            isBlank = command.data.isBlank,
        )
        validationResultSavePort.save(result)
    }
}