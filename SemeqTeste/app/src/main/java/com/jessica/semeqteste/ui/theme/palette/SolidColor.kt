package com.jessica.semeqteste.ui.theme.palette

import com.jessica.semeqteste.R


data class SolidColor(
    val scale100: Scale,
    val scale200: Scale,
    val scale300: Scale,
    val scale400: Scale,
    val scale500: Scale,
    val scale600: Scale,
    val scale700: Scale,
)

val Colors.whiteSolid: SolidColor
    get() = SolidColor(
        scale100 = Scale(R.color.white_solid_100),
        scale200 = Scale(R.color.white_solid_200),
        scale300 = Scale(R.color.white_solid_300),
        scale400 = Scale(R.color.white_solid_400),
        scale500 = Scale(R.color.white_solid_500),
        scale600 = Scale(R.color.white_solid_600),
        scale700 = Scale(R.color.white_solid_700),
    )

val Colors.blackSolid: SolidColor
    get() = SolidColor(
        scale100 = Scale(R.color.black_solid_100),
        scale200 = Scale(R.color.black_solid_200),
        scale300 = Scale(R.color.black_solid_300),
        scale400 = Scale(R.color.black_solid_400),
        scale500 = Scale(R.color.black_solid_500),
        scale600 = Scale(R.color.black_solid_600),
        scale700 = Scale(R.color.black_solid_700),
    )