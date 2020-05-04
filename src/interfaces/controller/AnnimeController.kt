package com.annime.core.interfaces.controller

import com.annime.core.interfaces.dto.AnnimeDto
import com.annime.core.interfaces.dto.toDto
import com.annime.core.usecase.AnnimeSeviceImple
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.route
import io.ktor.routing.get

fun Route.annimeController() {
    route("/annime") {
        get {
            val service = AnnimeSeviceImple()
            val annimes: List<AnnimeDto> = service.findBySeasonId(2).map { it.toDto() }
            println(annimes)
            call.respond(HttpStatusCode.OK, annimes)
        }
        get("/detail") {
            call.respond(HttpStatusCode.OK, "user detail routing ok")
        }
    }
}
