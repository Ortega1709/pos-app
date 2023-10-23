package com.ortega.exchange

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ortega.design.common.DialogComponent
import com.ortega.design.common.HeightSpacer
import com.ortega.design.common.Item
import com.ortega.design.common.TextComponent
import com.ortega.design.common.TextFieldComponent
import com.ortega.design.common.TopBarComponent
import com.ortega.design.theme.Padding
import com.ortega.design.theme.White
import com.ortega.domain.model.Rate
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExchangeScreen(
    drawerState: DrawerState,
    viewModel: ExchangeViewModel
) {



    val state = viewModel.state.collectAsStateWithLifecycle()

    var showDialog by remember { mutableStateOf(false) }
    var rateTextField by rememberSaveable { mutableStateOf(state.value.rate.rate.toString()) }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val scope = rememberCoroutineScope()


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
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                tint = White,
                                imageVector = Icons.Rounded.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    },
                    actions = {},
                    title = stringResource(id = R.string.exchange),
                    scrollBehavior = scrollBehavior
                )
            },
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier.padding(paddingValues)
            ) {

                item { HeightSpacer(height = Padding / 2) }

                item {
                    Item(
                        title = stringResource(R.string.actual_exchange),
                        subtitle = stringResource(R.string.insert_own_exchange),
                        trailing = {
                            TextComponent(
                                fontSize = 17.sp,
                                text = state.value.rate.rate.toString(),
                                color = White
                            )
                        },
                        onClickItem = { showDialog = true }
                    )
                }
            }
        }
    }


    if (showDialog) {
        DialogComponent(
            title = stringResource(R.string.update_rate_of_exchange),
            titleButton = stringResource(R.string.modify),
            setShowDialog = { showDialog = it },
            content = {
                TextFieldComponent(
                    placeholder = "Taux",
                    textField = rateTextField,
                    keyboardType = KeyboardType.Number,
                    onValueChange = { rateTextField = it }
                )
            },
            onClick = {
                viewModel.updateRate(rate = Rate(rateId = null, rate = rateTextField.toInt()))
                showDialog = false
            }
        )
    }
}