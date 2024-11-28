package com.example.myapplicationcoroutinetask1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCoroutineExample()
        }
    }
}

@Composable
fun SimpleCoroutineExample() {
    var message by remember { mutableStateOf("Appuyez sur le bouton pour démarrer") }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = message, modifier = Modifier.padding(bottom = 16.dp))

        Button(onClick = {
            coroutineScope.launch {
                // Mettre à jour le message pour montrer le chargement
                message = "Chargement en cours..."

                // Simuler un délai de 3 secondes
                delay(3000)

                // Mettre à jour le message après le délai
                message = "Données chargées avec succès !"
            }
        }) {
            Text("Démarrer")
        }
    }
}