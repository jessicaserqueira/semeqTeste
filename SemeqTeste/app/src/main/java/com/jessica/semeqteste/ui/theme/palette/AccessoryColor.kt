package com.jessica.semeqteste.ui.theme.palette

import com.jessica.semeqteste.R

data class AccessoryColor(
    val scale100: Scale,
    val scale200: Scale,
    val scale300: Scale,
    val scale400: Scale,
    val scale500: Scale,
    val scale600: Scale,
    val scale600Contrast: Scale,
    val scale700: Scale,
    val scaleGradStart: Scale,
    val scaleGradEnd: Scale
)

val Colors.pink: AccessoryColor
    get() = AccessoryColor(
        scale100 = Scale(R.color.pink_100),
        scale200 = Scale(R.color.pink_200),
        scale300 = Scale(R.color.pink_300),
        scale400 = Scale(R.color.pink_400),
        scale500 = Scale(R.color.pink_500),
        scale600 = Scale(R.color.pink_600),
        scale600Contrast = Scale(R.color.pink_600_contrast),
        scale700 = Scale(R.color.pink_700),
        scaleGradStart = Scale(R.color.pink_grad_start),
        scaleGradEnd = Scale(R.color.pink_grad_end),
    )
