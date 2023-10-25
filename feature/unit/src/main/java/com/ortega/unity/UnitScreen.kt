package com.ortega.unity

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.ortega.design.common.DialogComponent
import com.ortega.design.common.HeaderTextComponent
import com.ortega.design.common.HeightSpacer
import com.ortega.design.common.Item
import com.ortega.design.common.NothingScreenComponent
import com.ortega.design.common.TextFieldComponent
import com.ortega.design.common.TopBarComponent
import com.ortega.design.common.WidthSpacer
import com.ortega.design.theme.Blue
import com.ortega.design.theme.Padding
import com.ortega.design.theme.White
import com.ortega.domain.model.Unit
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UnitScreen(drawerState: DrawerState, viewModel: UnitViewModel) {

    val unitsLazyPagingItems = viewModel.unitsPaged.collectAsLazyPagingItems()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val scope = rememberCoroutineScope()

    var showInsertDialog by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }
    var showUpdateDialog by remember { mutableStateOf(false) }

    var unitElement by remember { mutableStateOf(Unit(unitId = null, name = "")) }
    var nameUnitField by remember { mutableStateOf("") }

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
                title = stringResource(id = R.string.unity),
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = Blue,
                contentColor = White,
                onClick = { showInsertDialog = true }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) { paddingValues ->

        if (unitsLazyPagingItems.itemCount == 0) {
            NothingScreenComponent(text = stringResource(R.string.nothing_units))
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                item { HeightSpacer(height = Padding / 2) }

                items(
                    count = unitsLazyPagingItems.itemCount,
                    key = unitsLazyPagingItems.itemKey { unit -> unit.unitId as Any },
                    contentType = unitsLazyPagingItems.itemContentType { "Unit" }
                ) {

                    unitsLazyPagingItems[it]?.let { unit ->
                        Item(
                            title = unit.name,
                            trailing = {
                                Row {
                                    IconButton(onClick = {
                                        unitElement = unit
                                        nameUnitField = unit.name
                                        showUpdateDialog = true
                                    }) {
                                        Icon(
                                            imageVector = Icons.Rounded.Edit,
                                            contentDescription = "Edit",
                                            tint = White
                                        )
                                    }

                                    WidthSpacer(width = Padding / 8)

                                    IconButton(onClick = {
                                        unitElement = unit
                                        showDeleteDialog = true
                                    }) {
                                        Icon(
                                            imageVector = Icons.Rounded.Delete,
                                            contentDescription = "Delete",
                                            tint = White
                                        )
                                    }
                                }
                            }
                        )
                    }
                }
                item { HeightSpacer(height = Padding * 5) }
            }
        }
    }

    if (showInsertDialog) {

        DialogComponent(
            title = stringResource(R.string.add_new_unit),
            titleButton = stringResource(R.string.add_unit),
            setShowDialog = { showInsertDialog = it },
            content = {
                TextFieldComponent(
                    placeholder = stringResource(id = R.string.unity),
                    maxLines = 1,
                    textField = nameUnitField,
                    keyboardType = KeyboardType.Text,
                    onValueChange = { nameUnitField = it }
                )
            },
            onClick = {
                if (nameUnitField.isNotEmpty()) {
                    viewModel.insertUnit(unit = Unit(unitId = null, name = nameUnitField))
                    showInsertDialog = false
                }
            }
        )

    }

    if (showUpdateDialog) {

        DialogComponent(
            title = stringResource(R.string.modify_unit),
            titleButton = stringResource(R.string.modify),
            setShowDialog = { showUpdateDialog = it },
            content = {
                TextFieldComponent(
                    placeholder = stringResource(id = R.string.unity),
                    maxLines = 1,
                    textField = nameUnitField,
                    keyboardType = KeyboardType.Text,
                    onValueChange = { nameUnitField = it }
                )
            },
            onClick = {
                if (nameUnitField.isNotEmpty()) {
                    viewModel.updateUnit(unit = Unit(unitId = unitElement.unitId, name = nameUnitField))
                    showUpdateDialog = false
                }
            }
        )

    }

    if (showDeleteDialog) {

        DialogComponent(
            title = stringResource(R.string.delete_unit),
            setShowDialog = { showDeleteDialog = it },
            content = {
                HeaderTextComponent(text = stringResource(R.string.sure_delete_unit))
            },
            onClick = {
               viewModel.deleteUnit(unitElement)
                showDeleteDialog = false
            }
        )

    }

}