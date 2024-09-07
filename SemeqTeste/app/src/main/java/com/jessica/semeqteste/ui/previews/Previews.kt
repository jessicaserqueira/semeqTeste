package com.jessica.semeqteste.ui.previews

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview("1 - Light mode", showBackground = true)
@Preview("2 - Dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("3 - Big font", showBackground = true, fontScale = 2f)
@Preview("4 - Small font", showBackground = true, fontScale = 0.6f)
annotation class Previews