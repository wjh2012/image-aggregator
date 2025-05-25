package com.ggomg.imageaggregator.adapter.inbound.message.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ThumbnailServicePayload(
    val bucket: String,
    @JsonProperty("thumbnail_object_key")
    val thumbnailObjectKey: String,
) : ServicePayload