package com.example.searchitemsapp.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itemTable")
data class ItemEntity(
    @ColumnInfo(name = "Title") var title:String,
    @ColumnInfo(name = "Sub_Title") var sub_Title:String,
    @ColumnInfo(name = "Item_Img") var item_Img:String,
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Item_Id")
    var Item_Id: Int? = null
}
