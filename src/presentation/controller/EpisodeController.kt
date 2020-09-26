package com.annime.core.presentation.controller

import com.annime.core.presentation.dto.*
import com.annime.core.usecase.EpisodeUseCase
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route
import org.koin.ktor.ext.inject

@KtorExperimentalLocationsAPI
@Location("/episodes/{annictId}")
data class Episodes(val annictId: Long)

@KtorExperimentalLocationsAPI
fun Route.episodeController() {
    val useCase: EpisodeUseCase by inject()

    get<Episodes> { p ->
        val episodes: List<EpisodeDto> = useCase.findByAnnictId(p.annictId).map { it.toDto() }
        call.respond(HttpStatusCode.OK, episodes)
    }
}
