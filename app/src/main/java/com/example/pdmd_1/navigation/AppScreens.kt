package com.example.pdmd_1.navigation

sealed class AppScreens(val route: String) {

    object MainScreen: AppScreens("MainScreen")
    object ChatScreen: AppScreens("ChatScreen")
}