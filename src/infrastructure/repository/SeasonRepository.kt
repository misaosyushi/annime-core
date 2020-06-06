package com.annime.core.infrastructure.repository

import com.annime.core.infrastructure.database.SeasonDao
import org.jetbrains.exposed.sql.transactions.transaction

interface ISeasonRepository {
    fun findAll(): List<SeasonDao>
}

class SeasonRepository : ISeasonRepository {

    override fun findAll(): List<SeasonDao> {
        return transaction {
            SeasonDao.all().toList()
        }
    }
}
