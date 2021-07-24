package com.example.searchitemsapp.model


import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("subTitle")
    var subTitle: String? = null,
    @SerializedName("title")
    var title: String? = null
)