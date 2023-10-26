package com.ortega.posapp.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ortega.category.CategoryScreen
import com.ortega.category.CategoryViewModel
import com.ortega.exchange.ExchangeScreen
import com.ortega.exchange.ExchangeViewModel
import com.ortega.home.HomeScreen
import com.ortega.home.HomeViewModel
import com.ortega.items.ItemsScreen
import com.ortega.purchases.PurchasesScreen
import com.ortega.unity.UnitScreen
import com.ortega.unity.UnitViewModel


@Composable
fun MainNavigation(
    navController: NavHostController,
    drawerState: DrawerState
) {

    val homeViewModel: HomeViewModel = hiltViewModel()
    val exchangeViewModel: ExchangeViewModel = hiltViewModel()
    val unitViewModel: UnitViewModel = hiltViewModel()
    val categoryViewModel: CategoryViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = MainScreens.Home.route) {

        composable(route = MainScreens.Home.route) {
            HomeScreen(drawerState = drawerState, viewModel = homeViewModel)
        }

        composable(route = MainScreens.Items.route) {
            ItemsScreen(drawerState = drawerState)
        }

        composable(route = MainScreens.Purchases.route) {
            PurchasesScreen()
        }

        composable(route = MainScreens.Categories.route) {
            CategoryScreen(drawerState = drawerState, viewModel = categoryViewModel)
        }

        composable(route = MainScreens.Exchange.route) {
            ExchangeScreen(drawerState = drawerState, viewModel = exchangeViewModel)
        }

        composable(route = MainScreens.Unity.route) {
            UnitScreen(drawerState = drawerState, viewModel = unitViewModel)
        }

    }

}