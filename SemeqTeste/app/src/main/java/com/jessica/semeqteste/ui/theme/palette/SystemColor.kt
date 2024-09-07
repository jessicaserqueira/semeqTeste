package com.jessica.semeqteste.ui.theme.palette

import com.jessica.semeqteste.R

data class SystemColor(
    val background: Scale,
    val elevation: Scale,
    val tooltip: Scale,
    val overlay: Scale,
)

val Colors.system: SystemColor
    get() = SystemColor(
        background = Scale(R.color.system_background),
        elevation = Scale(R.color.system_elevation),
        tooltip = Scale(R.color.system_tooltip),
        overlay = Scale(R.color.system_overlay),
    )
