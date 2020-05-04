package com.annime.core.interfaces.dto

data class CastDto(
    val name: String,
    val characterName: String?
)

fun CastDto.toDto(): CastDto {
    return CastDto(
        this.name,
        this.characterName
    )
}
