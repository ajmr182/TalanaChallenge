package com.example.talanachallenge.data.database

import androidx.lifecycle.LiveData
import com.example.talanachallenge.data.models.entities.FeedEntity


class FeedRepository(private val feedDao: FeedDao) {

    val readAllData: LiveData<List<FeedEntity>> = feedDao.readAllData()

    fun addTarea(feedEntity: FeedEntity) {

        feedDao.addFavorites(feedEntity)
    }
}

