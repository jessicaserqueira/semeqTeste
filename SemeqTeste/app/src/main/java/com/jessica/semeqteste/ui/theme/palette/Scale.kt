package com.jessica.semeqteste.ui.theme.palette

import androidx.annotation.ColorRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource

data class Scale internal constructor(@ColorRes val resColor: Int) {
    @Composable
    fun composeColor(): Color = colorResource(id = resColor)
}