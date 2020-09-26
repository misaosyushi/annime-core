package com.annime.core.presentation.dto

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
