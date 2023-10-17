package com.ortega.posapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Category
import androidx.compose.material.icons.rounded.CurrencyExchange
import androidx.compose.material.icons.rounded.Dashboard
import androidx.compose.material.icons.rounded.Inventory2
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Straighten
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ortega.design.auth.HeaderImageComponent
import com.ortega.design.common.TextComponent
import com.ortega.design.common.TopBarComponent
import com.ortega.design.theme.Black
import com.ortega.design.theme.DarkGray
import com.ortega.design.theme.PosAppTheme
import com.ortega.design.theme.White
import com.ortega.posapp.navigation.MainNavigation
import com.ortega.posapp.navigation.MainScreens
import com.ortega.posapp.navigation.NavigationItem
import kotlinx.coroutines.launch

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

    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    val screens = listOf(
        MainScreens.Home,
        MainScreens.Items,
        MainScreens.Purchases,
        MainScreens.Categories,
        MainScreens.Exchange,
        MainScreens.Unity
    )

    val items = listOf(
        NavigationItem(
            title = stringResource(id = com.ortega.home.R.string.dashboard),
            icon = Icons.Rounded.Dashboard
        ),
        NavigationItem(
            title = stringResource(com.ortega.items.R.string.articles),
            icon = Icons.Rounded.Inventory2
        ),
        NavigationItem(
            title = stringResource(com.ortega.purchases.R.string.achats),
            icon = Icons.Rounded.ShoppingCart
        ),
        NavigationItem(
            title = stringResource(com.ortega.categories.R.string.category),
            icon = Icons.Rounded.Category
        ),
        NavigationItem(
            title = stringResource(com.ortega.exchange.R.string.exchange),
            icon = Icons.Rounded.CurrencyExchange
        ),
        NavigationItem(
            title = stringResource(com.ortega.unity.R.string.unity),
            icon = Icons.Rounded.Straighten
        )
    )

    var selectedItem by rememberSaveable { mutableIntStateOf(0) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .width(300.dp),
                drawerContainerColor = Black,
            ) {

                HeaderImageComponent()
                items.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = DarkGray,
                            unselectedContainerColor = Black
                        ),
                        label = { TextComponent(text = item.title, color = White) },
                        selected = selectedItem == index,
                        icon = {
                            Icon(
                                tint = White,
                                imageVector = item.icon,
                                contentDescription = null
                            )
                        },
                        onClick = {
                            selectedItem = index
                            navController.popBackStack()
                            navController.navigate(screens[index].route)
                            coroutineScope.launch { drawerState.close() }
                        }
                    )
                }

            }
        }
    ) {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBarComponent(
                    navigationIcon = {
                        IconButton(onClick = { coroutineScope.launch { drawerState.open() } }) {
                            Icon(
                                tint = White,
                                imageVector = Icons.Rounded.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    },
                    actions = {},
                    title = items[selectedItem].title
                )
            }
        ) {
            MainNavigation(navController = navController)
        }
    }
}