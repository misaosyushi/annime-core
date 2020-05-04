package com.annime.core.infrastructure.database

import org.jetbrains.exposed.sql.Table

object Annimes: Table("annimes") {
    val id = long("id").primaryKey()
    val annictId = long("annict_id")
    val title = varchar("title", 100)
    val media = varchar("media", 10)
    val seasonId = integer("season_id")
    val officialSiteUrl = varchar("official_site_url", 400)
    val twitterUserName = varchar("twitter_user_name", 100).nullable()
    val imageUrl = varchar("image_url", 400).nullable()
}
