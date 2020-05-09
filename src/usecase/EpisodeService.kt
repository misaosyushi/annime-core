package com.annime.core.usecase

import com.annime.core.infrastructure.database.EpisodeDao
import com.annime.core.infrastructure.repository.EpisodeRepository

interface EpisodeService {

    fun findByAnnictId(annictId: Long): List<EpisodeDao>
}

class EpisodeServiceImpl(private val repository: EpisodeRepository) : EpisodeService {

    override fun findByAnnictId(annictId: Long): List<EpisodeDao> {
        return repository.findByAnnictId(annictId)
    }

}
