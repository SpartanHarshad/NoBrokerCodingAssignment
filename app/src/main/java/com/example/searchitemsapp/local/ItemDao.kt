package com.example.searchitemsapp.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.searchitemsapp.model.ResponseItem

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItemsIntoLocalDB(itemEntity: ItemEntity)

    @Query("select * from itemTable")
    fun showDataList(): LiveData<List<ItemEntity>>

}