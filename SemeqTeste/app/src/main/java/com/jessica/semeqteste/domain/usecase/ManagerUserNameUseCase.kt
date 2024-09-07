package com.jessica.semeqteste.domain.usecase

import com.jessica.semeqteste.data.datastore.DataStoreRepository

internal class ManagerUserNameUseCase(private val repository: DataStoreRepository) {
    suspend operator fun invoke(key: String, name: String) {
        repository.saveUsername(key, name)
    }
}
