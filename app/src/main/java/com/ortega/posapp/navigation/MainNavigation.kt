package com.ortega.posapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ortega.categories.CategoriesScreen
import com.ortega.exchange.ExchangeScreen
import com.ortega.home.HomeScreen
import com.ortega.items.ItemsScreen
import com.ortega.purchases.PurchasesScreen
import com.ortega.unity.UnityScreen


@Composable
fun MainNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = MainScreens.Home.route) {

        composable(route = MainScreens.Home.route) {
            HomeScreen()
        }

        composable(route = MainScreens.Items.route) {
            ItemsScreen()
        }

        composable(route = MainScreens.Purchases.route) {
            PurchasesScreen()
        }

        composable(route = MainScreens.Categories.route) {
            CategoriesScreen()
        }

        composable(route = MainScreens.Exchange.route) {
            ExchangeScreen()
        }

        composable(route = MainScreens.Unity.route) {
            UnityScreen()
        }

    }

}