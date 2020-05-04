package com.annime.core.infrastructure.repository

import com.annime.core.infrastructure.database.AnnimeDao
import com.annime.core.infrastructure.database.Annimes
import com.annime.core.infrastructure.database.Season
import org.jetbrains.exposed.sql.innerJoin
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

class AnnimeRepository {

    fun findAll(): List<AnnimeDao> {
        return transaction {
            AnnimeDao.all().toList()
        }
    }

    fun findById(id: Long): AnnimeDao? {
        return transaction {
            AnnimeDao.findById(id)
        }
    }

    fun findBySeasonId(seasonId: Int): List<AnnimeDao> {
        val query = transaction {
            Annimes.innerJoin(Season, { Annimes.seasonId }, { Season.id }).select { Annimes.seasonId eq seasonId }
        }
        return transaction {
            AnnimeDao.wrapRows(query).toList()
        }
    }
}
