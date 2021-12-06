package com.example.talanachallenge.ui.dashboard.ui.favorites

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.talanachallenge.R
import com.example.talanachallenge.data.models.entities.FeedEntity
import com.example.talanachallenge.databinding.FavoriteAdapterCustomRowBinding
import com.squareup.picasso.Picasso

class FavoriteAdapter(private var favoriteList: List<FeedEntity>) :
    RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.favorite_adapter_custom_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(favoriteList[position])
    }

    override fun getItemCount(): Int {

        return favoriteList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = FavoriteAdapterCustomRowBinding.bind(view)

        fun bind(favorite: FeedEntity) {

            Picasso.get().load(favorite.image).into(binding.ivPhoto)
            binding.tvTitle.text = favorite.title
            binding.tvContent.text = Html.fromHtml(favorite.description, Html.FROM_HTML_MODE_LEGACY)
        }
    }
}