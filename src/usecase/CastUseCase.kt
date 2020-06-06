package com.annime.core.usecase

import com.annime.core.infrastructure.database.CastDao
import com.annime.core.infrastructure.repository.ICastsRepository

class CastUseCase(private val repository: ICastsRepository) {

    fun findByAnnictId(annictId: Long): List<CastDao> {
        return repository.findByAnnictId(annictId)
    }

}
