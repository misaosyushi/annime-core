package com.annime.core.presentation.controller

import com.annime.core.presentation.dto.SeasonDto
import com.annime.core.presentation.dto.toDto
import com.annime.core.usecase.SeasonUseCase
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import org.koin.ktor.ext.inject

fun Route.seasonController() {
    val useCase: SeasonUseCase by inject()

    get("/season") {
        val season: List<SeasonDto> = useCase.findAll().map { it.toDto() }
        call.respond(HttpStatusCode.OK, season)
    }
}
