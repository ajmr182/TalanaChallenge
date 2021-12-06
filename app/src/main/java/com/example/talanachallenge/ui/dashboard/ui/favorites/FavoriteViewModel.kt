package com.example.talanachallenge.ui.dashboard.ui.favorites

import android.app.Application
import androidx.lifecycle.*
import com.example.talanachallenge.data.database.FeedDatabase
import com.example.talanachallenge.data.database.FeedRepository
import com.example.talanachallenge.data.models.entities.FeedEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: FeedRepository
    var readAllData: LiveData<List<FeedEntity>>

    init {

        val feedDao = FeedDatabase.getDatabase(application).feedDao()
        repository = FeedRepository(feedDao)
        readAllData=repository.readAllData
    }

    fun getAllFavorites() {

        viewModelScope.launch(Dispatchers.IO) {
            readAllData = repository.readAllData
        }
    }
}