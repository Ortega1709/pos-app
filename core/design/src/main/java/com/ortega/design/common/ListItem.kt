package com.ortega.design.common

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.ortega.design.theme.DarkGray
import com.ortega.design.theme.Gray
import com.ortega.design.theme.Padding
import com.ortega.design.theme.White

@Composable
fun Item(
    image: ImageVector,
    title: String,
    subtitle: String
) {

    ListItem(
        colors = listItemColorsComponent(),
        leadingContent = {
            Icon(imageVector = image, contentDescription = title, tint = White)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = Padding, end = Padding, top = Padding / 2)
            .border(width = 1.dp, color = DarkGray, shape = RoundedCornerShape(Padding)),
        headlineContent = { TextComponent(text = title, color = White) },
        supportingContent = { TextComponent(text = subtitle, color = Gray) }
    )

}

@Composable
fun Item(
    title: String,
    subtitle: String
) {

    ListItem(
        colors = listItemColorsComponent(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = Padding, end = Padding, top = Padding / 2)
            .border(width = 1.dp, color = DarkGray, shape = RoundedCornerShape(Padding)),
        headlineContent = { TextComponent(text = title, color = White) },
        supportingContent = { TextComponent(text = subtitle, color = Gray) }
    )

}

@Composable
fun Item(
    title: String,
    subtitle: String,
    trailing: @Composable (() -> Unit),
    onClickItem: () -> Unit
) {

    ListItem(
        colors = listItemColorsComponent(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = Padding, end = Padding, top = Padding / 2)
            .clickable { onClickItem() }
            .border(width = 1.dp, color = DarkGray, shape = RoundedCornerShape(Padding)),
        headlineContent = { TextComponent(text = title, color = White) },
        supportingContent = { TextComponent(text = subtitle, color = Gray) },
        trailingContent = trailing
    )

}

@Composable
fun Item(
    title: String,
    trailing: @Composable (() -> Unit),
) {

    ListItem(
        colors = listItemColorsComponent(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = Padding, end = Padding, top = Padding / 2)
            .border(width = 1.dp, color = DarkGray, shape = RoundedCornerShape(Padding)),
        headlineContent = { TextComponent(text = title, color = White) },
        trailingContent = trailing
    )

}