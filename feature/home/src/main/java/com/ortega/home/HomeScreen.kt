package com.ortega.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Category
import androidx.compose.material.icons.rounded.Inventory2
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Payments
import androidx.compose.material.icons.rounded.PointOfSale
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.Straighten
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ortega.design.common.HeightSpacer
import com.ortega.design.common.Item
import com.ortega.design.common.TopBarComponent
import com.ortega.design.theme.Padding
import com.ortega.design.theme.White
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    drawerState: DrawerState,
    viewModel: HomeViewModel
) {


    val state = viewModel.state.collectAsStateWithLifecycle()

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .fillMaxSize(),
        topBar = {
            TopBarComponent(
                navigationIcon = {
                    IconButton(onClick = { scope.launch { drawerState.open() } }) {
                        Icon(
                            tint = White,
                            imageVector = Icons.Rounded.Menu,
                            contentDescription = "Menu"
                        )
                    }
                },
                actions = {},
                title = stringResource(id = R.string.dashboard),
                scrollBehavior = scrollBehavior
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            item { HeightSpacer(height = Padding / 2) }

            item {

                Item(
                    image = Icons.Rounded.PointOfSale,
                    title = "0",
                    subtitle = stringResource(id = R.string.caisse)
                )

                Item(
                    image = Icons.Rounded.Payments,
                    title = "0",
                    subtitle = stringResource(id = R.string.ventes)
                )

                Item(
                    image = Icons.Rounded.ShoppingCart,
                    title = "0",
                    subtitle = stringResource(id = com.ortega.purchases.R.string.achats)
                )

                Item(
                    image = Icons.Rounded.Inventory2,
                    title = "0",
                    subtitle = stringResource(id = com.ortega.items.R.string.articles)
                )

                Item(
                    image = Icons.Rounded.Straighten,
                    title = state.value.units.toString(),
                    subtitle = stringResource(id = com.ortega.unity.R.string.unity)
                )

                Item(
                    image = Icons.Rounded.Category,
                    title = state.value.categories.toString(),
                    subtitle = stringResource(id = R.string.categor)
                )

            }
        }
    }
}