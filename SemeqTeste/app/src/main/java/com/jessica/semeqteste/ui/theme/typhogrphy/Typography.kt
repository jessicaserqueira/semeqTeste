package com.jessica.semeqteste.ui.theme.typhogrphy

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.jessica.semeqteste.ui.SemeqDesignSystem

private object Typeface {
    val WeightRegularDefault = FontWeight.W400
    val WeightStrongCustom = FontWeight(650)
}

class SemeqTypography internal constructor() {
    val baseRegular10 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightRegularDefault,
        fontStyle = FontStyle.Normal,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.01.sp,
    )
    val baseRegular12 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightRegularDefault,
        fontStyle = FontStyle.Normal,
        fontSize = 12.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.0.sp,
    )
    val baseRegular14 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightRegularDefault,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = (-0.006).sp,
    )
    val baseRegular16 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightRegularDefault,
        fontStyle = FontStyle.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = (-0.011).sp,
    )
    val baseRegular18 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightRegularDefault,
        fontStyle = FontStyle.Normal,
        fontSize = 18.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.014).sp,
    )
    val baseRegular20 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightRegularDefault,
        fontStyle = FontStyle.Normal,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = (-0.017).sp,
    )
    val baseRegular24 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightRegularDefault,
        fontStyle = FontStyle.Normal,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = (-0.019).sp,
    )
    val baseStrong10 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightStrongCustom,
        fontStyle = FontStyle.Normal,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.01.sp,
    )
    val baseStrong12 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightStrongCustom,
        fontStyle = FontStyle.Normal,
        fontSize = 12.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.0.sp,
    )
    val baseStrong14 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightStrongCustom,
        fontStyle = FontStyle.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        letterSpacing = (-0.006).sp,
    )
    val baseStrong16 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightStrongCustom,
        fontStyle = FontStyle.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = (-0.011).sp,
    )
    val baseStrong18 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightStrongCustom,
        fontStyle = FontStyle.Normal,
        fontSize = 18.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.014).sp,
    )
    val baseStrong20 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightStrongCustom,
        fontStyle = FontStyle.Normal,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = (-0.017).sp,
    )
    val baseStrong24 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightStrongCustom,
        fontStyle = FontStyle.Normal,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = (-0.019).sp,
    )
    val baseStrong28 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightStrongCustom,
        fontStyle = FontStyle.Normal,
        fontSize = 28.sp,
        lineHeight = 32.sp,
        letterSpacing = (-0.021).sp,
    )
    val baseStrong32 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightStrongCustom,
        fontStyle = FontStyle.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = (-0.022).sp,
    )
    val baseStrong36 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightStrongCustom,
        fontStyle = FontStyle.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = (-0.022).sp,
    )
    val baseStrong40 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightStrongCustom,
        fontStyle = FontStyle.Normal,
        fontSize = 40.sp,
        lineHeight = 48.sp,
        letterSpacing = (-0.022).sp,
    )
    val baseStrong44 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightStrongCustom,
        fontStyle = FontStyle.Normal,
        fontSize = 44.sp,
        lineHeight = 52.sp,
        letterSpacing = (-0.022).sp,
    )
    val baseStrong48 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightStrongCustom,
        fontStyle = FontStyle.Normal,
        fontSize = 48.sp,
        lineHeight = 56.sp,
        letterSpacing = (-0.022).sp,
    )
    val baseRegularItalic10 = TextStyle(
        fontFamily = Inter,
        fontWeight = Typeface.WeightRegularDefault,
        fontStyle = FontStyle.Italic,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.01.sp,
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewTypography() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Text(text = "baseRegular10", style = SemeqDesignSystem.typography.baseRegular10)
        Text(text = "baseRegular12", style = SemeqDesignSystem.typography.baseRegular12)
        Text(text = "baseRegular14", style = SemeqDesignSystem.typography.baseRegular14)
        Text(text = "baseRegular16", style = SemeqDesignSystem.typography.baseRegular16)
        Text(text = "baseRegular18", style = SemeqDesignSystem.typography.baseRegular18)
        Text(text = "baseRegular20", style = SemeqDesignSystem.typography.baseRegular20)
        Text(text = "baseRegular24", style = SemeqDesignSystem.typography.baseRegular24)

        HorizontalDivider()

        Text(text = "baseStrong10", style = SemeqDesignSystem.typography.baseStrong10)
        Text(text = "baseStrong12", style = SemeqDesignSystem.typography.baseStrong12)
        Text(text = "baseStrong14", style = SemeqDesignSystem.typography.baseStrong14)
        Text(text = "baseStrong16", style = SemeqDesignSystem.typography.baseStrong16)
        Text(text = "baseStrong18", style = SemeqDesignSystem.typography.baseStrong18)
        Text(text = "baseStrong20", style = SemeqDesignSystem.typography.baseStrong20)
        Text(text = "baseStrong24", style = SemeqDesignSystem.typography.baseStrong24)
        Text(text = "baseStrong28", style = SemeqDesignSystem.typography.baseStrong28)
        Text(text = "baseStrong32", style = SemeqDesignSystem.typography.baseStrong32)
        Text(text = "baseStrong36", style = SemeqDesignSystem.typography.baseStrong36)
        Text(text = "baseStrong40", style = SemeqDesignSystem.typography.baseStrong40)
        Text(text = "baseStrong44", style = SemeqDesignSystem.typography.baseStrong44)
        Text(text = "baseStrong48", style = SemeqDesignSystem.typography.baseStrong48)

        HorizontalDivider()

        Text(
            text = "baseRegularItalic10",
            style = SemeqDesignSystem.typography.baseRegularItalic10
        )
    }
}
