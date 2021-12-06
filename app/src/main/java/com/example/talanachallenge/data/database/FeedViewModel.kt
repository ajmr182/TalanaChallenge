package com.example.talanachallenge.data.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.talanachallenge.data.models.entities.FeedEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: FeedRepository
    lateinit var readAllData: LiveData<List<FeedEntity>>

    init {

        val feedDao = FeedDatabase.getDatabase(application).feedDao()
        repository = FeedRepository(feedDao)
    }

    fun addFavorite(feedEntity: FeedEntity) {

        viewModelScope.launch(Dispatchers.IO) {

            repository.addTarea(feedEntity)
        }
    }
}