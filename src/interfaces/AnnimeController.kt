package com.annime.core.interfaces

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.route
import io.ktor.routing.get
import org.jetbrains.exposed.sql.Database

fun Route.annimeController() {
    Database.connect("jdbc:mysql://0.0.0.0:13306/annime?useSSL=false", "com.mysql.jdbc.Driver", "annime", "annime")

    route("/annime") {
        get {
            call.respondText { "hogehoge" }
        }
        get("/detail") {
            call.respond(HttpStatusCode.OK, "user detail routing ok")
        }
    }
}
