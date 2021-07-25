package com.example.searchitemsapp.viewmodels

import android.app.Application
import com.example.searchitemsapp.local.LocalDatabase
import com.example.searchitemsapp.repository.ItemRepository

class ItemApplication:Application() {

    val itemDao by lazy {
        val database = LocalDatabase.getDatabaseInstance(this)
        database.getItemDao()
    }
    val itemRepository by lazy {
        ItemRepository(itemDao)
    }
}