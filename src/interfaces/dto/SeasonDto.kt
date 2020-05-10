package com.annime.core.interfaces.dto

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
