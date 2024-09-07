package com.jessica.semeqteste.ui.unofficial

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.jessica.semeqteste.ui.SemeqDesignSystem
import com.jessica.semeqteste.ui.previews.Previews
import com.jessica.semeqteste.ui.theme.palette.neutral
import com.jessica.semeqteste.ui.theme.palette.pink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextFieldComponent(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Column {
        Text(
            modifier = Modifier
                .padding(start = SemeqDesignSystem.spacing.spacingSmall16),
            text = label,
            color = SemeqDesignSystem.color.pink.scale500.composeColor(),
            style = SemeqDesignSystem.typography.baseStrong12
        )

        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp)),
            textStyle = SemeqDesignSystem.typography.baseStrong12,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = SemeqDesignSystem.color.neutral.scale100.composeColor(),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                }
            )
        )
    }
}


@Previews
@Composable
private fun SimpleTextFieldComponentPreview() {
    SimpleTextFieldComponent(
        value = "",
        label = "Label",
        onValueChange = { }
    )
}
