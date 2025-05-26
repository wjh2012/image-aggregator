package com.ggomg.imageaggregator.domain.model

enum class Status {
    SUCCESS, FAIL, PENDING;

    companion object {
        fun fromString(value: String): Status? {
            return entries.firstOrNull { it.name.equals(value, ignoreCase = true) }
        }
    }

    fun toValue(): String {
        return this.name.lowercase()
    }
}