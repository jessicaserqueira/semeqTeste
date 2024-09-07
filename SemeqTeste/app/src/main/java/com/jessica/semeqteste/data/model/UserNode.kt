package com.jessica.semeqteste.data.model

import com.google.gson.annotations.SerializedName

data class UserNode(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("level")
    val level: Int,
    @SerializedName("parent")
    val parent: Int?
)