package com.annime.core.infrastructure.database

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object Season : IntIdTable("season") {
    val seasonText = varchar("season_text", 20)
}

class SeasonDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<SeasonDao>(
        Season
    )

    var seasonText by Season.seasonText
}
