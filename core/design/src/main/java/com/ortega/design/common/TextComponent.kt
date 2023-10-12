package com.ortega.design.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

@Composable
fun TextComponent(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
) {

    Text(
        text = text,
        color = color,
        modifier = modifier
    )

}

@Composable
fun TextComponent(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontSize: TextUnit
) {

    Text(
        text = text,
        color = color,
        fontSize = fontSize,
        modifier = modifier,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )

}

@Composable
fun TextComponent(
    text: String,
    modifier: Modifier = Modifier,
    color: Color,
    fontWeight: FontWeight,
    fontSize: TextUnit
) {

    Text(
        text = text,
        color = color,
        fontWeight = fontWeight,
        fontSize = fontSize,
        modifier = modifier,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )

}