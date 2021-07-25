package com.example.searchitemsapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.searchitemsapp.repository.ItemRepository

class ItemViewModelFactory(val itemRepository: ItemRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ItemViewModel(itemRepository) as T
    }
}