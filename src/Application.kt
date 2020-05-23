package com.annime.core

import com.annime.core.infrastructure.repository.AnnimeRepository
import com.annime.core.infrastructure.repository.CastsRepository
import com.annime.core.infrastructure.repository.EpisodeRepository
import com.annime.core.infrastructure.repository.SeasonRepository
import com.annime.core.interfaces.controller.annimeController
import com.annime.core.interfaces.controller.castController
import com.annime.core.interfaces.controller.episodeController
import com.annime.core.interfaces.controller.seasonController
import com.annime.core.usecase.AnnimeSeviceImple
import com.annime.core.usecase.CastServiceImpl
import com.annime.core.usecase.EpisodeServiceImpl
import com.annime.core.usecase.SeasonServiceImpl
import io.ktor.application.*
import io.ktor.features.CORS
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Locations
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.jetbrains.exposed.sql.Database
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun main(args: Array<String>) {
    Database.connect("jdbc:mysql://0.0.0.0:13306/annime?useSSL=false", "com.mysql.jdbc.Driver", "annime", "annime")
    embeddedServer(
        Netty, watchPaths = listOf("build/classes"), port = 8080,
        module = Application::apiModule
    ).start(true)
}

@KtorExperimentalLocationsAPI
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
    startKoin {
        modules(injectModule)
    }
    routing {
        annimeController()
        episodeController()
        castController()
        seasonController()
    }
}

val injectModule = module {
    // Services
    single { AnnimeSeviceImple(get()) }
    single { CastServiceImpl(get()) }
    single { EpisodeServiceImpl(get()) }
    single { SeasonServiceImpl(get()) }

    // Repositories
    single { AnnimeRepository() }
    single { CastsRepository() }
    single { EpisodeRepository() }
    single { SeasonRepository() }
}
