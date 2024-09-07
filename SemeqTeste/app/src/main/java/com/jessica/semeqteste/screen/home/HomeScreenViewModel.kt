package com.jessica.semeqteste.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.jessica.semeqteste.data.datastore.PreferencesKeys
import com.jessica.semeqteste.data.model.UserNode
import com.jessica.semeqteste.domain.usecase.ApiUseCase
import com.jessica.semeqteste.domain.usecase.GetUserNameUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


internal open class HomeScreenViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val apiUseCase: ApiUseCase
) : ViewModel() {

    var name = MutableStateFlow("")
    var tree = MutableStateFlow<List<UserNode>>(emptyList())

    init {
        fetchUserName()
        fetchTree()
    }

    private fun fetchUserName() {
        viewModelScope.launch {
            getUserNameUseCase(PreferencesKeys.USERNAME.toString()).collect {
                name.value = it ?: ""
            }
        }
    }

    fun fetchTree() {
        viewModelScope.launch {
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val api = apiUseCase.getApi()
                    val response = api.getTree()
                    val treeData = response.body()?.map { it }
                    treeData?.let {
                        tree.value = it
                    }

                } catch (e: Exception) {
                    println("Erro ao buscar os dados: ${e.message}")
                }
            }
        }
    }

    companion object {
        fun create(
            getUserNameUseCase: GetUserNameUseCase,
            apiUseCase: ApiUseCase
        ): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                HomeScreenViewModel(
                    getUserNameUseCase,
                    apiUseCase
                )
            }
        }
    }
}

internal class MockHomeScreenViewModel(
    getUserNameUseCase: GetUserNameUseCase,
    apiUseCase: ApiUseCase
): HomeScreenViewModel(
    getUserNameUseCase,
    apiUseCase
) {
    companion object {
        fun create(
            getUserNameUseCase: GetUserNameUseCase,
            apiUseCase: ApiUseCase
        ): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                MockHomeScreenViewModel(
                    getUserNameUseCase,
                    apiUseCase
                )
            }
        }
    }
}