package com.jessica.semeqteste.data.api

import com.jessica.semeqteste.data.datastore.DataStoreRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class ApiService(private val okHttpClient: OkHttpClient) {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://apitestemobile-production.up.railway.app")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


    fun getApi(): AuthApiEndpoints {
        return retrofit.create(AuthApiEndpoints::class.java)
    }

}