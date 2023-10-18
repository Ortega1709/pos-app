package com.ortega.items

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import com.ortega.design.common.HeightSpacer
import com.ortega.design.common.TopBarComponent
import com.ortega.design.theme.Padding
import com.ortega.design.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsScreen(onOpenDrawer: () -> Unit) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            modifier = Modifier
                .nestedScroll(scrollBehavior.nestedScrollConnection)
                .fillMaxSize(),
            topBar = {
                TopBarComponent(
                    navigationIcon = {
                        IconButton(onClick = onOpenDrawer) {
                            Icon(
                                tint = White,
                                imageVector = Icons.Rounded.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    },
                    actions = {},
                    title = stringResource(id = R.string.articles),
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

            }
        }
    }
}

