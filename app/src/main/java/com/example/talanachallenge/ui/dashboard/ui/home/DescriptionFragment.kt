package com.example.talanachallenge.ui.dashboard.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.talanachallenge.R
import com.example.talanachallenge.databinding.FragmentDescriptionBinding
import com.squareup.picasso.Picasso

class DescriptionFragment : Fragment() {
    private val args by navArgs<DescriptionFragmentArgs>()
    private var _binding:FragmentDescriptionBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       initViews()
    }

    fun initViews(){
        binding.tvID.text = args.currentItem.id.toString()
        binding.tvDTitle.text = args.currentItem.title
        binding.tvDescription.text = args.currentItem.description
        Picasso.get().load(args.currentItem.image).into(binding.ivImage)
        binding.tvAuthorID.text = args.currentItem.author_id
        binding.tvPublish.text = args.currentItem.published
    }
}