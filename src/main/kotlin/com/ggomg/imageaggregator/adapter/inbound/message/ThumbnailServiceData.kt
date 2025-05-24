package com.ggomg.imageaggregator.adapter.inbound.message

import com.fasterxml.jackson.annotation.JsonProperty

data class ThumbnailServiceData(
    val bucket: String,
    @JsonProperty("thumbnail_object_key")
    val thumbnailObjectKey: String,
) : ServicePayload