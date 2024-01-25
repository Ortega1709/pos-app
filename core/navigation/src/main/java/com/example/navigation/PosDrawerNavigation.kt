package com.example.navigation

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ortega.design.auth.HeaderImageComponent
import com.ortega.design.common.TextComponent
import com.ortega.design.theme.Black
import com.ortega.design.theme.DarkGray
import com.ortega.design.theme.White
import com.ortega.home.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PosDrawerNavigation(
    navController: NavController,
    drawerState: DrawerState,
    posNavigation: @Composable () -> Unit
) {

    val scope = rememberCoroutineScope()


    val screens = listOf(
        PosScreens.Home,
        PosScreens.Items,
        PosScreens.Purchases,
        PosScreens.Categories,
        PosScreens.Exchange,
        PosScreens.Unity
    )

    val items = listOf(
        stringResource(R.string.dashboard),
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
        gesturesEnabled = enableGesture(navController = navController, screens = screens),
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .width(300.dp),
                drawerContainerColor = Black,
            ) {

                LazyColumn {
                    item { HeaderImageComponent() }
                    item {
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
                                    screen.icon?.let {
                                        Icon(
                                            tint = White,
                                            imageVector = it,
                                            contentDescription = null
                                        )
                                    }
                                },
                                onClick = {
                                    scope.launch {
                                        drawerState.close()
                                    }

                                    scope.launch {
                                        delay(190)
                                        navController.popBackStack()
                                        navController.navigate(screen.route)
                                    }
                                }
                            )
                        }
                    }
                }
            }
        },
        content = { posNavigation() }
    )
}

@Composable
fun enableGesture(navController: NavController, screens: List<PosScreens>): Boolean {
    return navController
        .currentBackStackEntryAsState()
        .value?.destination?.route in screens.map { it.route }
}