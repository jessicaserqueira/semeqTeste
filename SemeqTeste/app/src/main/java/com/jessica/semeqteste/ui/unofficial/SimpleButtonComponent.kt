package com.jessica.semeqteste.ui.unofficial

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.jessica.semeqteste.ui.SemeqDesignSystem
import com.jessica.semeqteste.ui.previews.Previews
import com.jessica.semeqteste.ui.theme.palette.neutral

@Composable
fun SimpleButtonComponent(
    modifier: Modifier,
    backgroundColor: Color,
    textColor: Color,
    text: String,
    onClick: () -> Unit,
    icon: Painter? = null,
    isEnabled: Boolean = true,
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .clickable(
                enabled = isEnabled,
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    bounded = true,
                    color = SemeqDesignSystem.color.neutral.scale100.composeColor()
                )
            )
            .background(backgroundColor)
            .padding(SemeqDesignSystem.spacing.spacingSmall12),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        if (icon != null) {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp)
            )
        }

        Text(
            text = text,
            color = textColor,
            style = SemeqDesignSystem.typography.baseStrong16
        )
    }
}

@Previews
@Composable
private fun SimpleButtonComponentPreview() {
    SimpleButtonComponent(
        text = "Play",
        backgroundColor = Color.White,
        onClick = {},
        isEnabled = true,
        textColor = Color.Black,
        modifier = Modifier
    )
}