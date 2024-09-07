package com.jessica.semeqteste.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.jessica.semeqteste.ui.SemeqDesignSystem
import com.jessica.semeqteste.ui.theme.palette.system

@Composable
fun SemeqTesteTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val lightScheme = lightColorScheme().copy(
        background = SemeqDesignSystem.color.system.background.composeColor()
    )

    val darkScheme = darkColorScheme().copy(
        background = SemeqDesignSystem.color.system.background.composeColor()
    )

    val colorScheme = if (darkTheme) darkScheme else lightScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}