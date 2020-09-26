package com.annime.core.presentation.dto

import com.annime.core.infrastructure.database.AnnimeDao

data class DetailDto(
    val id: Long,
    val annictId: Long,
    val title: String,
    val media: String,
    val officialSiteUrl: String,
    val twitterUserName: String?,
    val imageUrl: String?
)

fun AnnimeDao.toDetailDto(): DetailDto {
    return DetailDto(
        this.id.value,
        this.annictId,
        this.title,
        this.media,
        this.officialSiteUrl,
        this.twitterUserName,
        this.imageUrl
    )
}
