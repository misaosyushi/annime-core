package com.annime.core.usecase

import com.annime.core.infrastructure.database.SeasonDao
import com.annime.core.infrastructure.repository.SeasonRepository

interface SeasonService {
    fun findAll(): List<SeasonDao>
}

class SeasonServiceImpl(private val repository: SeasonRepository) : SeasonService {

    override fun findAll(): List<SeasonDao> {
        return repository.findAll()
    }

}
