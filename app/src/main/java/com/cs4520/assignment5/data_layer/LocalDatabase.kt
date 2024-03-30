package com.cs4520.assignment5.data_layer

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ProductEntity::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDAO

    companion object {

        @Volatile
        private var dbInstance: LocalDatabase? = null

        fun instance(context: Context): LocalDatabase {
            synchronized(this) {
                var instance = dbInstance

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        LocalDatabase::class.java,
                        "productsDB"
                    ).build()

                    dbInstance = instance
                }
                return instance
            }
        }
    }
}