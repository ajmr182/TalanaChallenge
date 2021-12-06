package com.example.talanachallenge.data.models.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "feed_table")
data class FeedEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val image: String,
    val description: String,
    val published: String,
    val author_id: String
) : Parcelable