package com.ortega.design.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ortega.design.R
import com.ortega.design.theme.PosAppTheme

@Composable
fun HeaderImageComponent() {

    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            modifier = Modifier.scale(.5f),
            painter = painterResource(R.drawable.caisse),
            contentDescription = stringResource(R.string.caisse)
        )

    }

}


@Preview(showSystemUi = true)
@Composable
fun HeaderImageComponentPreview() {
    PosAppTheme {
        HeaderImageComponent()
    }
}