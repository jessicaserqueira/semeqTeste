package com.jessica.semeqteste.domain.usecase

import com.jessica.semeqteste.data.datastore.DataStoreRepository
import kotlinx.coroutines.flow.Flow

internal class GetUserNameUseCase(private val repository: DataStoreRepository) {
    operator fun invoke(key: String): Flow<String?> {
        return repository.getUsername(key)
    }
}