package com.example.talanachallenge.ui.dashboard.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talanachallenge.databinding.FavoriteFragmentBinding

class FavoriteFragment : Fragment() {

    private lateinit var favoriteViewModel: FavoriteViewModel
    private var _binding: FavoriteFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoriteViewModel =
            ViewModelProvider(this)[FavoriteViewModel::class.java]
        _binding = FavoriteFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        favoriteViewModel.getAllFavorites()
        initViews()
        startObservables()
    }

    fun initViews() {

        binding.rvFavorites.layoutManager = LinearLayoutManager(requireContext())
    }

    fun startObservables() {

        favoriteViewModel.readAllData.observe(viewLifecycleOwner, Observer { lista->
            lista?.let {  binding.rvFavorites.adapter = FavoriteAdapter(it) }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}