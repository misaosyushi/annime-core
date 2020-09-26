package com.annime.core.presentation.dto

import com.annime.core.infrastructure.database.SeasonDao

data class SeasonDto(
    val id: Int,
    val seasonText: String
)

fun SeasonDao.toDto(): SeasonDto {
    return SeasonDto(
        this.id.value,
        this.seasonText
    )
}
