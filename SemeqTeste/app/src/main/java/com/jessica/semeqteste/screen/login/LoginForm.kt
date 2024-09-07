package com.jessica.semeqteste.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jessica.semeqteste.R
import com.jessica.semeqteste.ui.SemeqDesignSystem
import com.jessica.semeqteste.ui.previews.Previews
import com.jessica.semeqteste.ui.theme.palette.pink
import com.jessica.semeqteste.ui.theme.palette.whiteSolid
import com.jessica.semeqteste.ui.unofficial.SimpleButtonComponent
import com.jessica.semeqteste.ui.unofficial.SimpleTextFieldComponent

@Composable
internal fun LoginForm(
    onHome: (user: String, password: String) -> Unit,
) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(SemeqDesignSystem.spacing.spacingMedium32),
        modifier = Modifier
            .padding(horizontal = SemeqDesignSystem.spacing.spacingSmall16)
    ) {

        SimpleTextFieldComponent(
            value = user,
            label = stringResource(id = R.string.user),
            onValueChange = { user = it }
        )

        SimpleTextFieldComponent(
            value = password,
            label = stringResource(id = R.string.password),
            onValueChange = { password = it }
        )

        SimpleButtonComponent(
            modifier = Modifier
                .width(280.dp)
                .height(48.dp),
            text = stringResource(id = R.string.login),
            backgroundColor = SemeqDesignSystem.color.pink.scale500.composeColor(),
            textColor = SemeqDesignSystem.color.whiteSolid.scale700.composeColor(),
            isEnabled = true,
            onClick = {
                onHome(user, password)
            },
        )
    }
}

@Previews
@Composable
private fun Preview() {
    LoginForm(
        onHome = { _, _ -> }
    )
}