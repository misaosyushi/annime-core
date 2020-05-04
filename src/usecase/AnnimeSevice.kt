package com.annime.core.usecase

import com.annime.core.infrastructure.database.AnnimeDao
import com.annime.core.infrastructure.repository.AnnimeRepository

interface AnnimeSevice {

    fun findBySeasonId(seasonId: Int): List<AnnimeDao>
}

class AnnimeSeviceImple() : AnnimeSevice {

    private val repository = AnnimeRepository()

    override fun findBySeasonId(seasonId: Int): List<AnnimeDao> {
        return repository.findBySeasonId(seasonId)
    }

}
