package com.annime.core.usecase

import com.annime.core.infrastructure.database.AnnimeDao
import com.annime.core.infrastructure.repository.IAnnimeRepository

class AnnimeUseCase(private val repository: IAnnimeRepository) {

    fun findById(id: Long): AnnimeDao? {
        return repository.findById(id)
    }

    fun findBySeasonId(seasonId: Int): List<AnnimeDao> {
        return repository.findBySeasonId(seasonId)
    }

}
