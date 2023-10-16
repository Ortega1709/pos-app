package com.ortega.design.common

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun ToastComponent(text: String, length: Int) {
    val context = LocalContext.current
    Toast.makeText(context, text, length).show()
}