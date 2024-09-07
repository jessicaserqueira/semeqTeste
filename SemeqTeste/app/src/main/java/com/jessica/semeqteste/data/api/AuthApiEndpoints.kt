package com.jessica.semeqteste.data.api

import com.jessica.semeqteste.data.model.Auth
import com.jessica.semeqteste.data.model.LoginResponse
import com.jessica.semeqteste.data.model.UserNode
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApiEndpoints {
    @POST("/login")
    suspend fun login(@Body auth: Auth): Response<LoginResponse>

    @GET("/tree")
    suspend fun getTree(): Response<List<UserNode>>

}