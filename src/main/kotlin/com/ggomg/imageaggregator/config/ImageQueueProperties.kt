package com.ggomg.imageaggregator.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "services.image")
class ImageQueueProperties {

    var ocr: QueueDefinition = QueueDefinition()
    var validation: QueueDefinition = QueueDefinition()
    var thumbnail: QueueDefinition = QueueDefinition()

    class QueueDefinition {
        lateinit var exchange: String
        lateinit var queue: String
        lateinit var routingKey: String
    }
}