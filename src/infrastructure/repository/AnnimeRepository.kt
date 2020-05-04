package com.annime.core.infrastructure.repository

import com.annime.core.infrastructure.database.Annimes
import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.selectAll

class AnnimeRepository {

    fun findAll(): Query {
        return Annimes.selectAll()
    }
}
