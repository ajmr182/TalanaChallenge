package com.example.talanachallenge.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.talanachallenge.data.models.entities.FeedEntity

@Database(entities = [FeedEntity::class], version = 1, exportSchema = false)

abstract class FeedDatabase : RoomDatabase() {

    abstract fun feedDao(): FeedDao

    companion object {

        @Volatile
        private var INSTANCE: FeedDatabase? = null

        fun getDatabase(context: Context): FeedDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {

                return tempInstance
            }
            synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FeedDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}