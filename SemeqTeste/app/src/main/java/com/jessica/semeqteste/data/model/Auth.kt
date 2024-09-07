package com.jessica.semeqteste.data.model

import com.google.gson.annotations.SerializedName

data class Auth(
    @SerializedName("username")
    val userName: String,
    val password: String

)