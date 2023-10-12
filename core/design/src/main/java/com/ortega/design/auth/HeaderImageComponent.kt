package com.ortega.design.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ortega.design.R
import com.ortega.design.theme.PosAppTheme

@Composable
fun HeaderImageComponent() {

    Row (
        modifier = Modifier.fillMaxWidth()
    ) {

        Image(
            modifier = Modifier.scale(1f),
            painter = painterResource(R.drawable.caisse),
            contentDescription = "Caisse"
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