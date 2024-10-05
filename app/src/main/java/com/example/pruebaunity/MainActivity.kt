package com.example.pruebaunity


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

// No se debe poner en horizontal, bloquear la vista, solo vertical
@Composable
fun GameInterface() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo del espacio
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Fondo del espacio",
            modifier = Modifier.fillMaxSize()
        )

        // Ventana circular con el gato
        Box(
            modifier = Modifier
                .size(300.dp)
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = R.drawable.backgroundwindows),
                contentDescription = "Ventana",
                modifier = Modifier.fillMaxSize()
            )
            Image(
                painter = painterResource(id = R.drawable.cat),
                contentDescription = "Gato mirando al espacio",
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // Iconos de la interfaz
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /* Acción para ajustes */ }) {
                Icon(Icons.Default.Settings, contentDescription = "Ajustes")
            }
            IconButton(onClick = { /* Acción para mapa */ }) {
                Icon(Icons.Default.Map, contentDescription = "Mapa")
            }
            IconButton(onClick = { /* Acción para misiones */ }) {
                Icon(Icons.Default.Assignment, contentDescription = "Misiones")
            }
            IconButton(onClick = { /* Acción para minijuegos */ }) {
                Icon(Icons.Default.Games, contentDescription = "Minijuegos")
            }
        }
    }
}