package com.ggomg.imageaggregator.application

import com.ggomg.imageaggregator.domain.model.OcrResult
import com.ggomg.imageaggregator.domain.port.inbound.message.OcrResultMessageHandler
import com.ggomg.imageaggregator.domain.port.inbound.message.command.OcrResultCommand
import com.ggomg.imageaggregator.domain.port.inbound.message.command.ServiceCommand
import com.ggomg.imageaggregator.domain.port.outbound.OcrResultSavePort
import org.springframework.stereotype.Service


@Service
class OcrResultService(
    private val ocrResultSavePort: OcrResultSavePort,
) : OcrResultMessageHandler {
    override fun handleMessage(command: ServiceCommand<OcrResultCommand>) {
        val result = OcrResult(
            gid = command.gid,
            status = command.status,
            completedAt = command.completedAt,
            text = command.data.text?.joinToString("\n") ?: ""
        )
        ocrResultSavePort.save(result)
    }
}