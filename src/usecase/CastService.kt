package com.annime.core.usecase

import com.annime.core.infrastructure.database.CastDao
import com.annime.core.infrastructure.repository.CastsRepository

interface CastService {

    fun findByAnnictId(annictId: Long): List<CastDao>
}

class CastServiceImpl(private val repository: CastsRepository) : CastService {

    override fun findByAnnictId(annictId: Long): List<CastDao> {
        return repository.findByAnnictId(annictId)
    }

}
