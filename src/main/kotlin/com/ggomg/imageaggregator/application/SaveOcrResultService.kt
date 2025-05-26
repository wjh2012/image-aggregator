package com.ggomg.imageaggregator.application

import com.ggomg.imageaggregator.domain.model.OcrResult
import com.ggomg.imageaggregator.domain.model.Status
import com.ggomg.imageaggregator.domain.port.inbound.message.SaveOcrResultUseCase
import com.ggomg.imageaggregator.domain.port.inbound.message.command.OcrResultCommand
import com.ggomg.imageaggregator.domain.port.inbound.message.command.ServiceCommand
import com.ggomg.imageaggregator.domain.port.outbound.OcrResultSavePort
import org.springframework.stereotype.Service


@Service
class SaveOcrResultService(
    private val ocrResultSavePort: OcrResultSavePort,
) : SaveOcrResultUseCase {
    override fun saveOcrResult(command: ServiceCommand<OcrResultCommand>) {
        val result = OcrResult(
            gid = command.gid,
            status = Status.fromString(command.status)
                ?: throw IllegalArgumentException("Invalid status: ${command.status}"),
            completedAt = command.completedAt,
            text = command.data.text?.joinToString("\n") ?: ""
        )
        ocrResultSavePort.save(result)
    }
}