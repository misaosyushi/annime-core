package com.annime.core.infrastructure.database

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.LongIdTable

object Annimes : LongIdTable("annimes") {
    val annictId = long("annict_id").uniqueIndex()
    val title = varchar("title", 100)
    val media = varchar("media", 10)
    val seasonId = integer("season_id")
    val seasonText = Season.varchar("season_text", 20) // seasonテーブルとjoinするためここで定義
    val officialSiteUrl = varchar("official_site_url", 400)
    val twitterUserName = varchar("twitter_user_name", 100).nullable()
    val imageUrl = varchar("image_url", 400).nullable()
}

class AnnimeDao(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<AnnimeDao>(
        Annimes
    )

    var annictId by Annimes.annictId
    var title by Annimes.title
    var media by Annimes.media
    var seasonId by Annimes.seasonId // seasonテーブルとjoinするためここで定義
    var seasonText by Season.seasonText
    var officialSiteUrl by Annimes.officialSiteUrl
    var twitterUserName by Annimes.twitterUserName
    var imageUrl by Annimes.imageUrl
}
