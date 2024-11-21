package com.example.pdmd_1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pdmd_1.screens.ChatScreen
import com.example.pdmd_1.screens.MainScreen

/**
 * Función de navegación principal de la aplicación.
 *
 * Esta función maneja la navegación entre las pantallas principales utilizando un `NavController`.
 * Define las rutas a las que se puede navegar y asocia cada ruta con una pantalla composable correspondiente.
 */
@Composable
fun AppNavigation() {

    // Crear un NavController
    val navControlador = rememberNavController()

    // Definir el NavHost que contendrá las rutas de navegación
    NavHost(navController = navControlador, startDestination = AppScreens.MainScreen.route) {

        // Ruta para la pantalla principal
        composable(AppScreens.MainScreen.route) {
            MainScreen(navControlador)
        }

        // Ruta para la pantalla de chat, donde el nombre de usuario es un parámetro
        composable(
            AppScreens.ChatScreen.route + "/{nombre}",
            arguments = listOf(navArgument("nombre") { type = NavType.StringType })
        ) {

            val parametro = it.arguments?.getString("nombre")
            ChatScreen(navControlador, parametro)
        }
    }
}
