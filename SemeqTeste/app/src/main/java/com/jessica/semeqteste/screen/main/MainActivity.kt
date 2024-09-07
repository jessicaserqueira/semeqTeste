package com.jessica.semeqteste.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jessica.semeqteste.screen.Route
import com.jessica.semeqteste.screen.home.navigationHomeScreen
import com.jessica.semeqteste.screen.login.navigationLoginScreen
import com.jessica.semeqteste.ui.theme.SemeqTesteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SemeqTesteTheme {
                AppContent()
            }
        }
    }
}

@Composable
fun AppContent() {
    val navController = rememberNavController()
    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = Route.LOGIN.name
        ) {
            navigationLoginScreen(navController)
            navigationHomeScreen(navController)
        }
    }
}