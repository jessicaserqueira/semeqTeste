package com.jessica.semeqteste.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jessica.semeqteste.R
import com.jessica.semeqteste.data.datastore.DataStoreRepository
import com.jessica.semeqteste.domain.usecase.ApiUseCase
import com.jessica.semeqteste.domain.usecase.ManageAuthTokenUseCase
import com.jessica.semeqteste.domain.usecase.ManagerUserNameUseCase
import com.jessica.semeqteste.ui.SemeqDesignSystem
import com.jessica.semeqteste.ui.previews.Previews
import com.jessica.semeqteste.ui.theme.palette.pink
import com.jessica.semeqteste.ui.theme.palette.system
import com.jessica.semeqteste.ui.theme.palette.whiteSolid

@Composable
internal fun LoginScreen(
    viewModel: LoginScreenViewModel,
    navigateHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SemeqDesignSystem.color.pink.scale500.composeColor())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(top = SemeqDesignSystem.spacing.spacingMedium32)
                .background(SemeqDesignSystem.color.pink.scale500.composeColor()),
            contentAlignment = Alignment.TopCenter
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(
                        topStart = 40.dp,
                        topEnd = 10.dp,
                        bottomEnd = 40.dp,
                        bottomStart = 10.dp
                    ))
                    .background(SemeqDesignSystem.color.pink.scale500.composeColor()),
                contentAlignment = Alignment.TopCenter
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = null,
                    tint = SemeqDesignSystem.color.pink.scale500.composeColor(),
                    modifier = Modifier
                        .size(100.dp)
                        .background(SemeqDesignSystem.color.system.background.composeColor())
                        .padding(bottom = SemeqDesignSystem.spacing.spacingSmall16)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(SemeqDesignSystem.color.pink.scale500.composeColor()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 150.dp))
                    .background(SemeqDesignSystem.color.system.background.composeColor()),
                contentAlignment = Alignment.TopCenter
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(SemeqDesignSystem.spacing.spacingMedium32)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = stringResource(id = R.string.welcome),
                        style = SemeqDesignSystem.typography.baseStrong28,
                        color = SemeqDesignSystem.color.pink.scale500.composeColor(),
                        modifier = Modifier.padding(bottom = SemeqDesignSystem.spacing.spacingMedium32)
                    )

                    LoginForm(
                        onHome = { username, password ->
                            viewModel.authenticate(username, password)
                            navigateHome()
                        }
                    )
                }
            }

        }
    }
}

@Previews
@Composable
private fun Preview() {
    val context = LocalContext.current
    val dataStoreRepository = DataStoreRepository(context)
    val managerUserNameUseCase = ManagerUserNameUseCase(dataStoreRepository)
    val manageAuthTokenUseCase = ManageAuthTokenUseCase(dataStoreRepository)
    val apiUseCase = ApiUseCase(dataStoreRepository)
    val viewModel: MockLoginScreenViewModel = viewModel(
        factory = MockLoginScreenViewModel.create(
            managerUserNameUseCase,
            manageAuthTokenUseCase,
            apiUseCase
        )
    )
    LoginScreen(
        viewModel,
        navigateHome = {}
    )
}