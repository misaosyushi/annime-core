package com.annime.core.infrastructure.database

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.LongIdTable

object Casts : LongIdTable("casts") {
    val annictId = long("annict_id")
    val name = varchar("name", 40)
    val characterName = varchar("character_name", 40)
}

class CastDao(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<CastDao>(
        Casts
    )

    var annictId by Casts.annictId
    var name by Casts.name
    var characterName by Casts.characterName
}
