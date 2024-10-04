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

// C# (Unity)
using UnityEngine;

public class UnityBridgeReceiver : MonoBehaviour
{
    void RecibirAccion(string accion)
    {
        Debug.Log($"Acción recibida de Kotlin: {accion}");
        // Implementar lógica de juego basada en la acción recibida
    }

    public void EnviarMensajeAKotlin(string mensaje)
    {
        using (AndroidJavaClass unityPlayer = new AndroidJavaClass("com.unity3d.player.UnityPlayer"))
        using (AndroidJavaObject activity = unityPlayer.GetStatic<AndroidJavaObject>("currentActivity"))
        {
            activity.Call("runOnUiThread", new AndroidJavaRunnable(() =>
            {
                using (AndroidJavaClass bridgeClass = new AndroidJavaClass("com.tupackage.UnityBridge"))
                {
                    bridgeClass.CallStatic("receiveMessageFromUnity", mensaje);
                }
            }));
        }
    }
}