package com.ggomg.imageaggregator.application

import com.ggomg.imageaggregator.domain.model.Status
import com.ggomg.imageaggregator.domain.model.ValidationResult
import com.ggomg.imageaggregator.domain.port.inbound.message.SaveValidationResultUseCase
import com.ggomg.imageaggregator.domain.port.inbound.message.command.ServiceCommand
import com.ggomg.imageaggregator.domain.port.inbound.message.command.ValidationResultCommand
import com.ggomg.imageaggregator.domain.port.outbound.ValidationResultSavePort
import org.springframework.stereotype.Service


@Service
class SaveValidationResultService(
    private val validationResultSavePort: ValidationResultSavePort,
) : SaveValidationResultUseCase {
    override fun saveValidationResult(command: ServiceCommand<ValidationResultCommand>) {
        val result = ValidationResult(
            gid = command.gid,
            status = Status.fromString(command.status)
                ?: throw IllegalArgumentException("Invalid status: ${command.status}"),
            completedAt = command.completedAt,
            isBlank = command.data.isBlank,
        )
        validationResultSavePort.save(result)
    }
}