package com.annime.core.presentation.controller

import com.annime.core.presentation.dto.AnnimeDto
import com.annime.core.presentation.dto.DetailDto
import com.annime.core.presentation.dto.toDetailDto
import com.annime.core.presentation.dto.toDto
import com.annime.core.usecase.AnnimeUseCase
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route
import org.koin.ktor.ext.inject

@KtorExperimentalLocationsAPI
@Location("/annimes/{seasonId}")
data class Annimes(val seasonId: Int)

@KtorExperimentalLocationsAPI
@Location("/annimes/detail/{id}")
data class Detail(val id: Long)

@KtorExperimentalLocationsAPI
fun Route.annimeController() {
    val useCase: AnnimeUseCase by inject()

    get<Annimes> { p ->
        val annimes: List<AnnimeDto> = useCase.findBySeasonId(p.seasonId).map { it.toDto() }
        call.respond(HttpStatusCode.OK, annimes)
    }

    get<Detail> { p ->
        val detail: DetailDto? = useCase.findById(p.id)?.toDetailDto()
        detail?.let { call.respond(HttpStatusCode.OK, it) } ?: call.respond(HttpStatusCode.NotFound, "Not found.")
    }
}
