package com.jessica.semeqteste.domain.usecase

import com.jessica.semeqteste.data.api.ApiService
import com.jessica.semeqteste.data.api.AuthInterceptor
import com.jessica.semeqteste.data.datastore.DataStoreRepository
import okhttp3.OkHttpClient

internal class ApiUseCase(private val dataStoreRepository: DataStoreRepository) {
    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(dataStoreRepository))
            .build()
    }

    private val apiService: ApiService by lazy {
        ApiService(okHttpClient)
    }

    fun getApi() = apiService.getApi()
}
