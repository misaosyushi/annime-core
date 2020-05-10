package com.annime.core.interfaces.controller

import com.annime.core.interfaces.dto.SeasonDto
import com.annime.core.interfaces.dto.toDto
import com.annime.core.usecase.SeasonServiceImpl
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import org.koin.ktor.ext.inject

fun Route.seasonController() {
    val service: SeasonServiceImpl by inject()

    get("/season") {
        val season: List<SeasonDto> = service.findAll().map { it.toDto() }
        call.respond(HttpStatusCode.OK, season)
    }
}
