package com.example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun enableGesture(navController: NavController, screens: List<PosScreens>): Boolean {
    return navController
        .currentBackStackEntryAsState()
        .value?.destination?.route in screens.map { it.route }
}