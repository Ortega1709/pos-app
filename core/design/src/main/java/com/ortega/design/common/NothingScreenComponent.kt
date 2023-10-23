package com.ortega.design.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.ortega.design.R
import com.ortega.design.theme.Gray

@Composable
fun NothingScreenComponent(text: String) {

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier.scale(.8f),
            painter = painterResource(R.drawable.nothing),
            contentDescription = stringResource(R.string.caisse)
        )

        TextComponent(text = text, color = Gray)

    }

}