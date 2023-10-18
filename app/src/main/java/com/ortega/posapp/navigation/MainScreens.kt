package com.ortega.posapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Category
import androidx.compose.material.icons.rounded.CurrencyExchange
import androidx.compose.material.icons.rounded.Dashboard
import androidx.compose.material.icons.rounded.Inventory2
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Straighten
import androidx.compose.ui.graphics.vector.ImageVector


sealed class MainScreens(
    val route: String,
    val icon: ImageVector
) {

    object Home : MainScreens(route = "dashboard", icon = Icons.Rounded.Dashboard)
    object Items : MainScreens(route = "items", icon = Icons.Rounded.Inventory2)
    object Purchases : MainScreens("purchases", icon = Icons.Rounded.ShoppingCart)
    object Categories : MainScreens("categories", icon = Icons.Rounded.Category)
    object Exchange : MainScreens("exchanges", icon = Icons.Rounded.CurrencyExchange)
    object Unity : MainScreens("unity", icon = Icons.Rounded.Straighten)

}


