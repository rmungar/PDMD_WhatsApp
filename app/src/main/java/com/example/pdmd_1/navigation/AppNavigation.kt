package com.example.pdmd_1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pdmd_1.screens.ChatScreen
import com.example.pdmd_1.screens.MainScreen

@Composable

fun AppNavigation(){

    val navControlador = rememberNavController()

    NavHost(navController = navControlador, startDestination = AppScreens.MainScreen.route) {

        composable(AppScreens.MainScreen.route){
            MainScreen(navControlador)
        }
        composable(
            AppScreens.ChatScreen.route + "/{nombre}",
            arguments = listOf(navArgument("nombre") {type = NavType.StringType})
        ){
            val parametro = it.arguments?.getString("nombre")
            ChatScreen(navControlador, parametro)
        }


    }

}