package com.example.talanachallenge.ui.dashboard.ui.home

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.talanachallenge.data.database.FeedViewModel
import com.example.talanachallenge.data.models.entities.FeedEntity
import com.example.talanachallenge.databinding.FragmentDescriptionBinding
import com.squareup.picasso.Picasso

class DescriptionFragment : Fragment() {
    private val args by navArgs<DescriptionFragmentArgs>()
    private var _binding: FragmentDescriptionBinding? = null
    private val binding get() = _binding!!
    private lateinit var feedViewModel: FeedViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        feedViewModel = ViewModelProvider(this)[FeedViewModel::class.java]
        _binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initViews()

        binding.btnAddToFavorites.setOnClickListener {

            val feedInformation =
                FeedEntity(
                    binding.tvID.text.toString().toInt(),
                    binding.tvDTitle.text.toString(),
                    binding.ivImage.toString(),
                    binding.tvDescription.text.toString(),
                    binding.tvPublish.text.toString(),
                    binding.tvAuthorID.text.toString()
                )
            feedViewModel.addFavorite(feedInformation)
        }
    }

    private fun initViews() {

        binding.tvID.text = "id: ${args.currentItem.id.toString()}"
        binding.tvDTitle.text = args.currentItem.title
        binding.tvDescription.text = Html.fromHtml(args.currentItem.description)
        Picasso.get().load(args.currentItem.image).into(binding.ivImage)
        binding.tvAuthorID.text = "Author ID: ${args.currentItem.author_id}"
        binding.tvPublish.text = "Published: ${args.currentItem.published}"
    }
}