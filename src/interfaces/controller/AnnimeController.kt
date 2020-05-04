package com.annime.core.interfaces.controller

import com.annime.core.infrastructure.repository.AnnimeRepository
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.route
import io.ktor.routing.get
import org.jetbrains.exposed.sql.transactions.transaction

fun Route.annimeController() {
    route("/annime") {
        get {
            val repository = AnnimeRepository()
            transaction {
                repository.findAll().map { println(it) }
            }
            call.respondText { "hogehoge" }
        }
        get("/detail") {
            call.respond(HttpStatusCode.OK, "user detail routing ok")
        }
    }
}
