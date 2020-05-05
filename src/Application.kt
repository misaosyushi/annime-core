package com.annime.core

import com.annime.core.interfaces.controller.annimeController
import com.annime.core.interfaces.controller.castController
import com.annime.core.interfaces.controller.episodeController
import io.ktor.application.*
import io.ktor.features.CORS
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.locations.Locations
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.jetbrains.exposed.sql.Database

fun main(args: Array<String>) {
    Database.connect("jdbc:mysql://0.0.0.0:13306/annime?useSSL=false", "com.mysql.jdbc.Driver", "annime", "annime")

    embeddedServer(
        Netty, watchPaths = listOf("build/classes"), port = 8080,
        module = Application::apiModule
    ).start(true)
}


fun Application.apiModule() {
    install(ContentNegotiation) {
        gson {
        }
    }
    install(Locations)
    install(CORS) {
        // TODO: 環境によって許可するドメインを指定するようにする
        anyHost()
    }
    routing {
        annimeController()
        episodeController()
        castController()
    }
}
