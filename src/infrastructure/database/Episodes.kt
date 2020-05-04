package com.annime.core.infrastructure.database

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.LongIdTable

object Episodes : LongIdTable("episodes") {
    val annictId = long("annict_id")
    val numberText = varchar("number_text", 10)
    val title = varchar("title", 100).nullable()
}

class EpisodeDao(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<EpisodeDao>(
        Episodes
    )

    var annictId by Episodes.annictId
    var numberText by Episodes.numberText
    var title by Episodes.title
}
