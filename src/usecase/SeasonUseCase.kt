package com.annime.core.usecase

import com.annime.core.infrastructure.database.SeasonDao
import com.annime.core.infrastructure.repository.ISeasonRepository

class SeasonUseCase(private val repository: ISeasonRepository) {

    fun findAll(): List<SeasonDao> {
        return repository.findAll()
    }

}
