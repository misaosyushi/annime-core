package com.annime.core.presentation.controller

import com.annime.core.presentation.dto.CastDto
import com.annime.core.presentation.dto.toDto
import com.annime.core.usecase.CastUseCase
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route
import org.koin.ktor.ext.inject

@KtorExperimentalLocationsAPI
@Location("/casts/{annictId}")
data class Casts(val annictId: Long)

@KtorExperimentalLocationsAPI
fun Route.castController() {
    val useCase: CastUseCase by inject()

    get<Casts> { p ->
        val casts: List<CastDto> = useCase.findByAnnictId(p.annictId).map { it.toDto() }
        call.respond(HttpStatusCode.OK, casts)
    }
}

