package com.example.searchitemsapp.clicklistener

import com.example.searchitemsapp.local.ItemEntity
import com.example.searchitemsapp.model.ResponseItem

interface OnClickListener {

    fun onItemClick(responseModel: ItemEntity)
}