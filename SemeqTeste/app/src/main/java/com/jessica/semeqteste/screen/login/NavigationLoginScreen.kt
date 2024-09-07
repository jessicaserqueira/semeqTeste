package com.jessica.semeqteste.screen.login

import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jessica.semeqteste.data.datastore.DataStoreRepository
import com.jessica.semeqteste.domain.usecase.ApiUseCase
import com.jessica.semeqteste.domain.usecase.GetUserNameUseCase
import com.jessica.semeqteste.domain.usecase.ManageAuthTokenUseCase
import com.jessica.semeqteste.domain.usecase.ManagerUserNameUseCase
import com.jessica.semeqteste.screen.Route
import com.jessica.semeqteste.screen.home.navigateToHomeScreen

internal fun NavGraphBuilder.navigationLoginScreen(navController: NavController) {
    composable(
        Route.LOGIN.name,
    ) { backStackEntry ->
        val context = LocalContext.current
        val dataStoreRepository = DataStoreRepository(context)
        val managerUserNameUseCase = ManagerUserNameUseCase(dataStoreRepository)
        val manageAuthTokenUseCase = ManageAuthTokenUseCase(dataStoreRepository)
        val apiUseCase = ApiUseCase(dataStoreRepository)

        val viewModel: LoginScreenViewModel = viewModel(
            viewModelStoreOwner = backStackEntry,
            factory = LoginScreenViewModel.create(
                managerUserNameUseCase = managerUserNameUseCase,
                manageAuthTokenUseCase = manageAuthTokenUseCase,
                apiUseCase = apiUseCase
            )
        )
        LoginScreen(
            viewModel = viewModel,
            navigateHome = {
                navController.navigateToHomeScreen()
            }
        )
    }
}