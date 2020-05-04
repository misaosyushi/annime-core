package com.annime.core

import com.annime.core.interfaces.annimeController
import io.ktor.application.*
import io.ktor.http.HttpStatusCode
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    embeddedServer(
        Netty, watchPaths = listOf("build/classes"), port = 8080,
        module = Application::apiModule
    ).start()
}


fun Application.apiModule() {
    routing {
        annimeController()
    }
}
