package com.annime.core.infrastructure.repository

import com.annime.core.infrastructure.database.CastDao
import com.annime.core.infrastructure.database.Casts
import org.jetbrains.exposed.sql.transactions.transaction

interface ICastsRepository {
    fun findByAnnictId(annictId: Long): List<CastDao>
}

class CastsRepository : ICastsRepository {

    override fun findByAnnictId(annictId: Long): List<CastDao> {
        return transaction {
            CastDao.find { Casts.annictId eq annictId }.toList()
        }
    }
}
