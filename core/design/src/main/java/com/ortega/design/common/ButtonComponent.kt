package com.ortega.design.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ortega.design.theme.Blue
import com.ortega.design.theme.HeightButton
import com.ortega.design.theme.Padding
import com.ortega.design.theme.White

@Composable
fun ButtonComponent(
    isLoading: Boolean = false,
    enable: Boolean = true,
    onClick: () -> Unit,
    text: String
) {

    Button(
        onClick = onClick,
        enabled = enable,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue,
            disabledContainerColor = Blue.copy(alpha = .5f),
            disabledContentColor = White
        ),
        modifier = Modifier
            .height(height = HeightButton)
            .fillMaxWidth()
            .padding(horizontal = Padding)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutLinearInEasing
                )
            )
    ) {

        AnimatedVisibility(visible = isLoading) {
            Row {
                CircularProgressIndicator(
                    color = White,
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp)

                )
                WidthSpacer(width = Padding / 2)
            }
        }
        

        TextComponent(
            text = text,
            fontSize = 16.sp,
            color = White
        )

    }

}