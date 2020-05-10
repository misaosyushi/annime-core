package com.annime.core.infrastructure.repository

import com.annime.core.infrastructure.database.SeasonDao
import org.jetbrains.exposed.sql.transactions.transaction

class SeasonRepository {

    fun findAll(): List<SeasonDao> {
        return transaction {
            SeasonDao.all().toList()
        }
    }
}
