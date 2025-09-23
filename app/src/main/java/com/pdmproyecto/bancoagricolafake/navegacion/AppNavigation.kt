package com.pdmproyecto.bancoagricolafake.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pdmproyecto.bancoagricolafake.ui.pages.LogIn
import com.pdmproyecto.bancoagricolafake.ui.pages.Menu

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LogIn(navController)
        }
        composable("menu") {
            Menu()
        }
    }
}
