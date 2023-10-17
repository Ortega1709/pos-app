package com.ortega.posapp.navigation


sealed class MainScreens(
    val route: String,
) {

    object Home : MainScreens(route = "dashboard")
    object Items : MainScreens(route = "items")
    object Purchases : MainScreens("purchases")
    object Categories : MainScreens("categories")
    object Exchange : MainScreens("exchanges")
    object Unity : MainScreens("unity")

}


