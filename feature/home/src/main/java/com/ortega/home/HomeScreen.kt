package com.ortega.home

import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ortega.design.common.HeightSpacer
import com.ortega.design.common.Item
import com.ortega.design.common.TopBarComponent
import com.ortega.design.theme.Padding
import com.ortega.design.theme.White

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                TopBarComponent(
                    navigationIcon = {
                        IconButton(
                            onClick = { /*TODO*/ }
                        ) {
                            Icon(
                                tint = White,
                                imageVector = Icons.Rounded.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    },
                    actions = {},
                    title = stringResource(id = R.string.dashboard)
                )
            },
            modifier = Modifier.fillMaxSize(),
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
                        title = "0",
                        subtitle = stringResource(id = com.ortega.unity.R.string.unity)
                    )

                    Item(
                        image = Icons.Rounded.Category,
                        title = "45",
                        subtitle = stringResource(id = com.ortega.categories.R.string.category)
                    )

                }
            }
        }
    }

}