package com.annime.core.infrastructure.repository

import com.annime.core.infrastructure.database.EpisodeDao
import com.annime.core.infrastructure.database.Episodes
import org.jetbrains.exposed.sql.transactions.transaction

interface IEpisodeRepository {
    fun findByAnnictId(annictId: Long): List<EpisodeDao>
}

class EpisodeRepository : IEpisodeRepository {

    override fun findByAnnictId(annictId: Long): List<EpisodeDao> {
        return transaction {
            EpisodeDao.find { Episodes.annictId eq annictId }.toList()
        }
    }
}
