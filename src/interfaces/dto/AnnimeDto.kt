package com.annime.core.interfaces.dto

import com.annime.core.infrastructure.database.AnnimeDao

data class AnnimeDto(
    val id: Long,
    val annictId: Long,
    val title: String,
    val media: String,
    val season: String,
    val officialSiteUrl: String,
    val twitterUserName: String?,
    val imageUrl: String?
)

fun AnnimeDao.toDto(): AnnimeDto {
    return AnnimeDto(
        this.id.value,
        this.annictId,
        this.title,
        this.media,
        this.seasonText,
        this.officialSiteUrl,
        this.twitterUserName,
        this.imageUrl
    )
}
