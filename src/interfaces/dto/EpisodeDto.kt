package com.annime.core.interfaces.dto

import com.annime.core.infrastructure.database.EpisodeDao

data class EpisodeDto(
    val numberText: String,
    val title: String?
)

fun EpisodeDao.toDto(): EpisodeDto {
    return EpisodeDto(
        this.numberText,
        this.title
    )
}
