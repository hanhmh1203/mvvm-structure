package com.example.gear_kotlin.network

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.gear_kotlin.base.BaseFragment
import com.example.commons.extension.getViewModel
import com.example.gear_kotlin.databinding.FragmentHomeBinding
import com.example.gear_kotlin.network.views.HomeAdapter

import javax.inject.Inject

/**
 * A simple [BaseFragment] subclass
 * that will show a list of top [User] from Github's API.
 */
class HomeFragment : BaseFragment() {

    // FOR DATA
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    lateinit var  viewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = getViewModel(factory)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        configureRecyclerView()

    }


    private fun configureRecyclerView() {
        binding.fragmentHomeRv.adapter = HomeAdapter(viewModel)
    }
}
