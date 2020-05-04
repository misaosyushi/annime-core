package com.annime.core.interfaces.controller

import com.annime.core.interfaces.dto.AnnimeDto
import com.annime.core.interfaces.dto.DetailDto
import com.annime.core.interfaces.dto.toDetailDto
import com.annime.core.interfaces.dto.toDto
import com.annime.core.usecase.AnnimeSeviceImple
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route

@KtorExperimentalLocationsAPI
@Location("/annimes/{seasonId}")
data class Annimes(val seasonId: Int)

@KtorExperimentalLocationsAPI
@Location("/annimes/detail/{id}")
data class Detail(val id: Long)

@KtorExperimentalLocationsAPI
fun Route.annimeController() {
    val service = AnnimeSeviceImple()

    get<Annimes> { p ->
        val annimes: List<AnnimeDto> = service.findBySeasonId(p.seasonId).map { it.toDto() }
        call.respond(HttpStatusCode.OK, annimes)
    }

    get<Detail> { p ->
        val detail: DetailDto? = service.findById(p.id)?.toDetailDto()
        detail?.let { call.respond(HttpStatusCode.OK, it) } ?: call.respond(HttpStatusCode.NotFound, "Not found.")
    }
}
