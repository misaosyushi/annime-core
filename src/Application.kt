package com.annime.core

import com.annime.core.infrastructure.repository.*
import com.annime.core.presentation.controller.annimeController
import com.annime.core.presentation.controller.castController
import com.annime.core.presentation.controller.episodeController
import com.annime.core.presentation.controller.seasonController
import com.annime.core.usecase.*
import com.typesafe.config.ConfigFactory
import io.ktor.application.*
import io.ktor.config.HoconApplicationConfig
import io.ktor.features.CORS
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Locations
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.jetbrains.exposed.sql.Database
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun main(args: Array<String>) {
    val config = HoconApplicationConfig(ConfigFactory.load())
    Database.connect(
        config.property("db.url").getString(),
        config.property("db.driver").getString(),
        config.property("db.user").getString(),
        config.property("db.pass").getString()
    )
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
        get("/health") {
            call.respond(HttpStatusCode.OK, "Health OK")
        }
        annimeController()
        episodeController()
        castController()
        seasonController()
    }
}

val injectModule = module {
    // Services
    single { AnnimeUseCase(get()) }
    single { CastUseCase(get()) }
    single { EpisodeUseCase(get()) }
    single { SeasonUseCase(get()) }

    // Repositories
    single { AnnimeRepository() as IAnnimeRepository }
    single { CastsRepository() as ICastsRepository }
    single { EpisodeRepository() as IEpisodeRepository }
    single { SeasonRepository() as ISeasonRepository }
}
