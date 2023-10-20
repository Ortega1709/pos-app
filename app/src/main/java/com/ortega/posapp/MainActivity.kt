package com.ortega.posapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ortega.design.auth.HeaderImageComponent
import com.ortega.design.common.TextComponent
import com.ortega.design.theme.Black
import com.ortega.design.theme.DarkGray
import com.ortega.design.theme.PosAppTheme
import com.ortega.design.theme.White
import com.ortega.posapp.navigation.MainNavigation
import com.ortega.posapp.navigation.MainScreens
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PosAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(navController = rememberNavController())
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {

    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val screens = listOf(
        MainScreens.Home,
        MainScreens.Items,
        MainScreens.Purchases,
        MainScreens.Categories,
        MainScreens.Exchange,
        MainScreens.Unity
    )

    val items = listOf(
        stringResource(com.ortega.home.R.string.dashboard),
        stringResource(com.ortega.items.R.string.articles),
        stringResource(com.ortega.purchases.R.string.achats),
        stringResource(com.ortega.categories.R.string.category),
        stringResource(com.ortega.exchange.R.string.exchange),
        stringResource(com.ortega.unity.R.string.unity)
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .width(300.dp),
                drawerContainerColor = Black,
            ) {

                HeaderImageComponent()
                screens.forEachIndexed { index, screen ->
                    NavigationDrawerItem(
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = DarkGray,
                            unselectedContainerColor = Black
                        ),
                        label = { TextComponent(text = items[index], color = White) },
                        selected = currentDestination
                            ?.hierarchy
                            ?.any { destination ->
                                destination.route == screen.route
                            } == true,
                        icon = {
                            Icon(
                                tint = White,
                                imageVector = screen.icon,
                                contentDescription = null
                            )
                        },
                        onClick = {
                            scope.launch {
                                drawerState.close()
                            }

                            scope.launch {
                                delay(200)
                                navController.popBackStack()
                                navController.navigate(screen.route)
                            }
                        }
                    )
                }
            }
        }
    ) {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
        ) {
            MainNavigation(
                navController = navController,
                drawerState = drawerState
            )
        }
    }
}