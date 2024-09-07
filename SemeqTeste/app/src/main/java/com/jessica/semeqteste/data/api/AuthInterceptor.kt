package com.jessica.semeqteste.data.api

import com.jessica.semeqteste.data.datastore.DataStoreRepository
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

internal class AuthInterceptor(private val dataStoreRepository: DataStoreRepository) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        val token = runBlocking {
            dataStoreRepository.token.firstOrNull()
        }
        println("Token JWT: $token")
        token?.let {
            requestBuilder.addHeader("Authorization", "Bearer $it")
        }

        return chain.proceed(requestBuilder.build())
    }
}