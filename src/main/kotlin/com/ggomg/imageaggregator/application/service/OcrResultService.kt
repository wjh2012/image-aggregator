package com.ggomg.imageaggregator.application.service

import com.ggomg.imageaggregator.domain.model.OcrResult
import com.ggomg.imageaggregator.application.port.inbound.OcrResultMessageHandler
import com.ggomg.imageaggregator.application.port.inbound.command.OcrResultCommand
import com.ggomg.imageaggregator.application.port.outbound.OcrResultSavePort
import org.springframework.stereotype.Service


@Service
class OcrResultService(
    private val ocrResultSavePort: OcrResultSavePort,
) : OcrResultMessageHandler {
    override fun handleMessage(command: OcrResultCommand) {
        val result = OcrResult(
            gid = command.gid,
            status = command.status,
            completedAt = command.completedAt,
            text = command.ocrResults?.joinToString("\n") ?: ""
        )
        ocrResultSavePort.save(result)
    }
}