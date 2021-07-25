package com.example.searchitemsapp.model


import com.google.gson.annotations.SerializedName

data class ResponseItem(
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("subTitle")
    var subTitle: String? = null,
    @SerializedName("title")
    var title: String? = null
)