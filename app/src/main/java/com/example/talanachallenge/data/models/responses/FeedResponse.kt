package com.example.talanachallenge.data.models.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeedResponse (
    @SerializedName("id") val id:Int,
    @SerializedName("title") val title:String,
    @SerializedName("image") val image:String,
    @SerializedName("description") val description:String,
    @SerializedName("published") val published:String,
    @SerializedName("author_id") val author_id: String
        ):Parcelable