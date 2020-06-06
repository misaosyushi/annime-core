package com.annime.core.usecase

import com.annime.core.infrastructure.database.EpisodeDao
import com.annime.core.infrastructure.repository.IEpisodeRepository

class EpisodeUseCase(private val repository: IEpisodeRepository) {

    fun findByAnnictId(annictId: Long): List<EpisodeDao> {
        return repository.findByAnnictId(annictId)
    }

}
