package com.jessica.semeqteste.screen.home

import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jessica.semeqteste.data.datastore.DataStoreRepository
import com.jessica.semeqteste.domain.usecase.ApiUseCase
import com.jessica.semeqteste.domain.usecase.GetUserNameUseCase
import com.jessica.semeqteste.screen.Route

internal fun NavGraphBuilder.navigationHomeScreen(navController: NavController) {
    composable(
        Route.HOME.name,
    ) { backStackEntry ->

        val context = LocalContext.current
        val dataStore = DataStoreRepository(context)
        val getUserNameUseCase = GetUserNameUseCase(dataStore)
        val apiUseCase = ApiUseCase(dataStore)

        val viewModel: HomeScreenViewModel = viewModel(
            viewModelStoreOwner = backStackEntry,
            factory = HomeScreenViewModel.create(
                getUserNameUseCase = getUserNameUseCase,
                apiUseCase = apiUseCase
            )
        )
        HomeScreen(viewModel)
    }
}

internal fun NavController.navigateToHomeScreen() {
    navigate(Route.HOME.name)
}