package org.example.project

import io.ktor.client.HttpClient
import io.ktor.client.engine.js.Js
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class JsPlatform: Platform {
    override val name: String = "Web with Kotlin/JS"
}

actual fun getPlatform(): io.ktor.util.Platform {
    TODO("Not yet implemented")
}

actual fun createHttpClient(): HttpClient {
    return HttpClient(Js){
        install(ContentNegotiation){
            json(Json{ ignoreUnknownKeys = true})
        }
    }
}