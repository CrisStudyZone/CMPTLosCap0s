package org.example.project

import io.ktor.client.HttpClient
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun createHttpClient(): HttpClient {
    TODO("Not yet implemented")
}