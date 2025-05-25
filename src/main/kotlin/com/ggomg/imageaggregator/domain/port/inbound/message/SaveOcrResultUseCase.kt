package com.ggomg.imageaggregator.domain.port.inbound.message

import com.ggomg.imageaggregator.domain.port.inbound.message.command.OcrResultCommand
import com.ggomg.imageaggregator.domain.port.inbound.message.command.ServiceCommand

interface SaveOcrResultUseCase {
    fun saveOcrResult(command: ServiceCommand<OcrResultCommand>)
}