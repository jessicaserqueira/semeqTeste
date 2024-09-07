package com.jessica.semeqteste.domain.usecase

import com.jessica.semeqteste.data.datastore.DataStoreRepository

internal class ManageAuthTokenUseCase(private val repository: DataStoreRepository) {
    suspend fun saveToken(token: String) = repository.saveToken(token)
}