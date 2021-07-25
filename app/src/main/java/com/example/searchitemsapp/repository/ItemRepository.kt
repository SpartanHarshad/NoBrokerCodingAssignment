package com.example.searchitemsapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.searchitemsapp.local.ItemDao
import com.example.searchitemsapp.local.ItemEntity
import com.example.searchitemsapp.model.ResponseItem
import com.example.searchitemsapp.remote.ApiService
import com.example.searchitemsapp.remote.RetrofitGenerator

class ItemRepository(val itemDao: ItemDao) {

    val apiService = RetrofitGenerator.getInstance().create(ApiService::class.java)

      suspend fun getItemListFromApiAndAdd() {
          val response: List<ResponseItem> = apiService.getItemList()
          for (i in 0 until response.size) {
              val title = response[i].title
              val subTitle =  response[i].subTitle
              val img = response[i].image
              val itemsEntity = ItemEntity(title!!,subTitle!!,img!!)
              itemDao.insertItemsIntoLocalDB(itemsEntity)
          }
    }

    fun showListDataRepo():LiveData<List<ItemEntity>>{
        Log.d("TAG","${itemDao.showDataList().toString()}")
        return itemDao.showDataList()
    }
}