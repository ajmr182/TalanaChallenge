package com.example.talanachallenge.ui.dashboard.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.talanachallenge.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
startObservables()
    }

    fun startObservables() {
        homeViewModel.requestFeed()
        homeViewModel.feedResponse.observe(viewLifecycleOwner, Observer {
            val adapter = HomeAdapter(it)
            Toast.makeText(requireContext(), "ok", Toast.LENGTH_SHORT).show()
            binding.feedRecyclerView.setHasFixedSize(true)
            binding.feedRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.feedRecyclerView.adapter = adapter
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}