package com.annime.core.interfaces.controller

import com.annime.core.interfaces.dto.AnnimeDto
import com.annime.core.interfaces.dto.toDto
import com.annime.core.usecase.AnnimeSeviceImple
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get

@KtorExperimentalLocationsAPI
@Location("/annimes/{seasonId}")
data class Annimes(val seasonId: Int)

@KtorExperimentalLocationsAPI
fun Route.annimeController() {
    val service = AnnimeSeviceImple()

    get<Annimes> { p ->
        val annimes: List<AnnimeDto> = service.findBySeasonId(p.seasonId).map { it.toDto() }
        println(annimes)
        call.respond(HttpStatusCode.OK, annimes)
    }

    get("/detail") {
        call.respond(HttpStatusCode.OK, "user detail routing ok")
    }
}
