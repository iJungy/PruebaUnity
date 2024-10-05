package com.example.pruebaunity

// Kotlin (Android)
class UnityBridge {
    companion object {
        init {
            System.loadLibrary("unity")
        }

        external fun sendMessageToUnity(gameObjectName: String, methodName: String, message: String)

        @JvmStatic
        fun receiveMessageFromUnity(message: String) {
            // Procesar mensajes recibidos de Unity
            println("Mensaje recibido de Unity: $message")
        }
    }
}

// Uso en Kotlin
fun enviarAccionAUnity(accion: String) {
    UnityBridge.sendMessageToUnity("GameManager", "RecibirAccion", accion)
}
