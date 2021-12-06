package com.example.talanachallenge.data.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.talanachallenge.data.models.entities.FeedEntity

@Dao
interface FeedDao {

    @Query("SELECT * FROM feed_table")
    fun readAllData(): LiveData<List<FeedEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addFavorites(feedEntity: FeedEntity)

}