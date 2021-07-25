package com.example.searchitemsapp.remote

import com.example.searchitemsapp.model.ResponseItem
import com.example.searchitemsapp.model.ResponseModel
import retrofit2.http.GET

interface ApiService {

    @GET("shivarajp/2cbe00030c04472c9d8ad4b0ec112dbe/raw/c651391e428182f08d60d59e79073f3fcf79b858/nobroker")
    suspend fun getItemList():ArrayList<ResponseItem>
}