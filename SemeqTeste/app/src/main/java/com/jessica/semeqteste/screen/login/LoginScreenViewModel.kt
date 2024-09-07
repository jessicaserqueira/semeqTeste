package com.jessica.semeqteste.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.jessica.semeqteste.domain.usecase.ManageAuthTokenUseCase
import com.jessica.semeqteste.data.datastore.PreferencesKeys
import com.jessica.semeqteste.data.model.Auth
import com.jessica.semeqteste.domain.usecase.ApiUseCase
import com.jessica.semeqteste.domain.usecase.GetUserNameUseCase
import com.jessica.semeqteste.domain.usecase.ManagerUserNameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

internal open class LoginScreenViewModel(
    private val managerUserNameUseCase: ManagerUserNameUseCase,
    private val manageAuthTokenUseCase: ManageAuthTokenUseCase,
    private val apiUseCase: ApiUseCase
) : ViewModel() {

    var name = MutableStateFlow("")

    fun authenticate(userName: String, password: String) {
        viewModelScope.launch {
            try {
                val api = apiUseCase.getApi()
                val response = api.login(Auth(userName, password))
                if (response.isSuccessful) {
                    val token = response.body()?.accessToken
                    if (token != null) {
                        println("Token JWT recebido: $token")
                        manageAuthTokenUseCase.saveToken(token)
                    }
                    managerUserNameUseCase.invoke(PreferencesKeys.USERNAME.toString(), userName)
                    name.value = userName
                } else {
                    println("Falha na autenticação: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                println("Erro de autenticação: ${e.message}")
            }
        }
    }

    companion object {
        fun create(
            managerUserNameUseCase: ManagerUserNameUseCase,
            manageAuthTokenUseCase: ManageAuthTokenUseCase,
            apiUseCase: ApiUseCase
        ): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                LoginScreenViewModel(
                    managerUserNameUseCase,
                    manageAuthTokenUseCase,
                    apiUseCase
                )
            }
        }
    }
}

internal class MockLoginScreenViewModel(
    managerUserNameUseCase: ManagerUserNameUseCase,
    manageAuthTokenUseCase: ManageAuthTokenUseCase,
    apiUseCase: ApiUseCase
) : LoginScreenViewModel(
    managerUserNameUseCase,
    manageAuthTokenUseCase,
    apiUseCase
) {
    companion object {
        fun create(
            managerUserNameUseCase: ManagerUserNameUseCase,
            manageAuthTokenUseCase: ManageAuthTokenUseCase,
            apiUseCase: ApiUseCase
        ): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                MockLoginScreenViewModel(
                    managerUserNameUseCase,
                    manageAuthTokenUseCase,
                    apiUseCase
                )
            }
        }
    }
}