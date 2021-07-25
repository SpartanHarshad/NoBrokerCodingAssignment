package com.example.searchitemsapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.searchitemsapp.local.ItemEntity
import com.example.searchitemsapp.model.ResponseItem
import com.example.searchitemsapp.repository.ItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel(val repository: ItemRepository):ViewModel() {

     fun getItemListFromAPi(){
         CoroutineScope(Dispatchers.IO).launch {
             repository.getItemListFromApiAndAdd()
         }
    }

    fun showListData():LiveData<List<ItemEntity>>{
        return repository.showListDataRepo()
    }
}