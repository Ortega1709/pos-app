package com.ortega.design.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ortega.design.theme.DarkGray
import com.ortega.design.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(
    navigationIcon: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit,
    title: String,
    scrollBehavior: TopAppBarScrollBehavior
) {


    Column (
        modifier = Modifier.fillMaxWidth()
    ) {

        MediumTopAppBar(
            scrollBehavior = scrollBehavior,
            navigationIcon = navigationIcon,
            title = {
                TextComponent(
                    text = title,
                    color = White
                )
            },
            actions = actions
        )

        Divider(
            color = DarkGray,
            thickness = 1.dp
        )

    }
}