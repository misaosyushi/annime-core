package com.annime.core.presentation.dto

import com.annime.core.infrastructure.database.CastDao

data class CastDto(
    val name: String,
    val characterName: String?
)

fun CastDao.toDto(): CastDto {
    return CastDto(
        this.name,
        this.characterName
    )
}
