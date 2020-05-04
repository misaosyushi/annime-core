package com.annime.core.interfaces.controller

import com.annime.core.interfaces.dto.*
import com.annime.core.usecase.EpisodeServiceImpl
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route

@KtorExperimentalLocationsAPI
@Location("/episodes/{annictId}")
data class Episodes(val annictId: Long)

@KtorExperimentalLocationsAPI
fun Route.episodeController() {
    val service = EpisodeServiceImpl()

    get<Episodes> { p ->
        val annimes: List<EpisodeDto> = service.findByAnnictId(p.annictId).map { it.toDto() }
        call.respond(HttpStatusCode.OK, annimes)
    }
}
