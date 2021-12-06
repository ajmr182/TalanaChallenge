package com.example.talanachallenge.ui.dashboard.ui.home

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.talanachallenge.R
import com.example.talanachallenge.data.models.responses.FeedResponse
import com.example.talanachallenge.databinding.HomeAdapterCustomRowBinding
import com.squareup.picasso.Picasso
import retrofit2.Response

class HomeAdapter(private var information: Response<List<FeedResponse>>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.home_adapter_custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val notification = information.body()?.get(position)
        if (notification != null) {

            holder.bind(notification)
        }
    }

    override fun getItemCount(): Int {

        return information.body()!!.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = HomeAdapterCustomRowBinding.bind(view)

        fun bind(notification: FeedResponse) {

            Picasso.get().load(notification.image).into(binding.ivPhoto)
            binding.tvTitle.text = notification.title
            binding.tvContent.text =
                Html.fromHtml(notification.description, Html.FROM_HTML_MODE_LEGACY)
            binding.cardViewHome.setOnClickListener {

                val action =
                    HomeFragmentDirections.actionNavigationHomeToDescriptionFragment(notification)
                itemView.findNavController().navigate(action)
            }
        }
    }
}