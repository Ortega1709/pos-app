package com.example.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ortega.auth.AuthViewModel
import com.ortega.auth.login.LoginScreen
import com.ortega.auth.register.RegisterScreen
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
fun PosNavigation(
    navController: NavHostController,
    drawerState: DrawerState
) {

    val homeViewModel: HomeViewModel = hiltViewModel()
    val exchangeViewModel: ExchangeViewModel = hiltViewModel()
    val unitViewModel: UnitViewModel = hiltViewModel()
    val categoryViewModel: CategoryViewModel = hiltViewModel()

    val authViewModel: AuthViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = PosScreens.Home.route) {

        composable(route = PosScreens.Home.route) {
            HomeScreen(drawerState = drawerState, viewModel = homeViewModel)
        }

        composable(route = PosScreens.Items.route) {
            ItemsScreen(drawerState = drawerState)
        }

        composable(route = PosScreens.Purchases.route) {
            PurchasesScreen()
        }

        composable(route = PosScreens.Categories.route) {
            CategoryScreen(drawerState = drawerState, viewModel = categoryViewModel)
        }

        composable(route = PosScreens.Exchange.route) {
            ExchangeScreen(drawerState = drawerState, viewModel = exchangeViewModel)
        }

        composable(route = PosScreens.Unity.route) {
            UnitScreen(drawerState = drawerState, viewModel = unitViewModel)
        }

        // Auth Navigation
//        composable(route = PosScreens.Login.route) {
//            LoginScreen(
//                viewModel = authViewModel,
//                goToHomeScreen = {
//                    navController.navigate(PosScreens.Home.route)
//                },
//            );
//        }
//
//        composable(route = PosScreens.Register.route) {
//            RegisterScreen(
//                viewModel = authViewModel,
//                goToLoginScreen = {
//                    navController.navigate(PosScreens.Login.route)
//                },
//            )
//        }

    }

}