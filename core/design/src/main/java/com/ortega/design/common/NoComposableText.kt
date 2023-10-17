package com.ortega.design.common

import android.content.Context
import androidx.annotation.StringRes

fun NoComposableText(context: Context, @StringRes id: Int): String =
    context.resources.getString(id)