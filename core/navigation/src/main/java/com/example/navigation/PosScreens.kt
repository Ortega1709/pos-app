package com.example.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Category
import androidx.compose.material.icons.rounded.CurrencyExchange
import androidx.compose.material.icons.rounded.Dashboard
import androidx.compose.material.icons.rounded.Inventory2
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Straighten
import androidx.compose.ui.graphics.vector.ImageVector


sealed class PosScreens(
    val route: String,
    val icon: ImageVector?
) {

    // Auth
    object Login: PosScreens(route = "login", icon = null)
    object Register: PosScreens(route = "register", icon = null)

    // Main
    object Home : PosScreens(route = "dashboard", icon = Icons.Rounded.Dashboard)
    object Items : PosScreens(route = "items", icon = Icons.Rounded.Inventory2)
    object Purchases : PosScreens("purchases", icon = Icons.Rounded.ShoppingCart)
    object Categories : PosScreens("categories", icon = Icons.Rounded.Category)
    object Exchange : PosScreens("exchanges", icon = Icons.Rounded.CurrencyExchange)
    object Unity : PosScreens("unity", icon = Icons.Rounded.Straighten)

}


