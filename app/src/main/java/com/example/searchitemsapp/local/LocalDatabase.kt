package com.example.searchitemsapp.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [ItemEntity::class], version = 1)

abstract class LocalDatabase : RoomDatabase() {

    abstract fun getItemDao(): ItemDao

    companion object {
        private var INSTANCE: LocalDatabase? = null
        fun getDatabaseInstance(context: Context): LocalDatabase {
            if (INSTANCE == null) {
                var builder = Room.databaseBuilder(
                    context.applicationContext,
                    LocalDatabase::class.java,
                    "Item_Db"
                )
                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
                return INSTANCE!!
            }
            return INSTANCE!!
        }
    }
}