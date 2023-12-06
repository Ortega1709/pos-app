package com.ortega.category

import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.ortega.categories.R
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
import com.ortega.domain.model.Category
import kotlinx.coroutines.launch

@Composable
fun CategoryScreen(
    drawerState: DrawerState,
    viewModel: CategoryViewModel
) {

    val categoriesLazyPagingItems = viewModel.categoriesPaged.collectAsLazyPagingItems()
    val scope = rememberCoroutineScope()

    var showInsertDialog by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }
    var showUpdateDialog by remember { mutableStateOf(false) }

    var categoryElement by remember { mutableStateOf(Category(categoryId = null, name = "")) }
    var nameCategoryField by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(

            modifier = Modifier
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
                    actions = { },
                    title = stringResource(id = R.string.category),
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
            },
            content = { paddingValues ->
                if (categoriesLazyPagingItems.itemCount == 0) {
                    NothingScreenComponent(text = stringResource(R.string.nothing_category))
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {

                        item { HeightSpacer(height = Padding / 2) }

                        items(
                            count = categoriesLazyPagingItems.itemCount,
                            key = categoriesLazyPagingItems.itemKey { category ->
                                category.categoryId as Any
                            },
                            contentType = categoriesLazyPagingItems.itemContentType { "Category" }
                        ) {

                            categoriesLazyPagingItems[it]?.let { category ->
                                Item(
                                    title = category.name,
                                    trailing = {
                                        Row {
                                            IconButton(onClick = {
                                                categoryElement = category
                                                nameCategoryField = category.name
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
                                                categoryElement = category
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
        )
    }

    if (showInsertDialog) {

        DialogComponent(
            title = stringResource(R.string.add_new_category),
            titleButton = stringResource(R.string.add_category),
            setShowDialog = { showInsertDialog = it },
            content = {
                TextFieldComponent(
                    placeholder = stringResource(id = R.string.category),
                    maxLines = 1,
                    textField = nameCategoryField,
                    keyboardType = KeyboardType.Text,
                    onValueChange = { nameCategoryField = it }
                )
            },
            onClick = {
                if (nameCategoryField.isNotEmpty()) {
                    viewModel.insertCategory(Category(categoryId = null, name = nameCategoryField))
                    showInsertDialog = false
                }
            }
        )

    }

    if (showUpdateDialog) {

        DialogComponent(
            title = stringResource(R.string.modify_category),
            titleButton = stringResource(R.string.modify),
            setShowDialog = { showUpdateDialog = it },
            content = {
                TextFieldComponent(
                    placeholder = stringResource(id = R.string.category),
                    maxLines = 1,
                    textField = nameCategoryField,
                    keyboardType = KeyboardType.Text,
                    onValueChange = { nameCategoryField = it }
                )
            },
            onClick = {
                if (nameCategoryField.isNotEmpty()) {
                    viewModel.updateCategory(
                        Category(categoryId = categoryElement.categoryId, name = nameCategoryField)
                    )
                    showUpdateDialog = false
                }
            }
        )

    }

    if (showDeleteDialog) {

        DialogComponent(
            title = stringResource(R.string.delete_category),
            setShowDialog = { showDeleteDialog = it },
            content = {
                HeaderTextComponent(text = stringResource(R.string.sure_delete_category))
            },
            onClick = {
                viewModel.deleteCategory(categoryElement)
                showDeleteDialog = false
            }
        )

    }

}