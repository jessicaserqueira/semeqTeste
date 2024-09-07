package com.jessica.semeqteste.ui.theme.palette

import com.jessica.semeqteste.R

data class NeutralColor(
    val scale50: Scale,
    val scale100: Scale,
    val scale100Alpha: Scale,
    val scale200: Scale,
    val scale200Alpha: Scale,
    val scale300: Scale,
    val scale300Alpha: Scale,
    val scale400: Scale,
    val scale500: Scale,
    val scale600: Scale,
    val scale700: Scale,
    val scaleGradStart: Scale,
    val scaleGradEnd: Scale
)

val Colors.neutral: NeutralColor
    get() = NeutralColor(
        scale50 = Scale(R.color.neutral_50),
        scale100 = Scale(R.color.neutral_100),
        scale100Alpha = Scale(R.color.neutral_100_alpha),
        scale200 = Scale(R.color.neutral_200),
        scale200Alpha = Scale(R.color.neutral_200_alpha),
        scale300 = Scale(R.color.neutral_300),
        scale300Alpha = Scale(R.color.neutral_300_alpha),
        scale400 = Scale(R.color.neutral_400),
        scale500 = Scale(R.color.neutral_500),
        scale600 = Scale(R.color.neutral_600),
        scale700 = Scale(R.color.neutral_700),
        scaleGradStart = Scale(R.color.neutral_grad_start),
        scaleGradEnd = Scale(R.color.neutral_grad_end),
    )