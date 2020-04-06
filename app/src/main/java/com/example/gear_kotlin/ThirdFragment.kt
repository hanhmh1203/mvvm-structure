package com.example.gear_kotlin

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.Observer

import com.example.commons.base.BaseFragment
import com.example.gear_kotlin.databinding.FragmentThirdBinding



class ThirdFragment : BaseFragment() {

    private  lateinit var viewModel: ThirdFragmentViewModel
    private lateinit var binding : FragmentThirdBinding // generate by layout name
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ThirdFragmentViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.user.observe(viewLifecycleOwner, Observer {
            Log.i("ThirdFragment","user value ${viewModel.user.value!!.name}")
            binding.viewModel = viewModel
        })
        // TODO: Use the ViewModel
    }

    override fun onStop() {
        super.onStop()
        Log.i("ThirdFragment","onStop user value ${viewModel.user.value!!.name}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ThirdFragment"," onDestroy user value ${viewModel.user.value!!.name}")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("ThirdFragment"," onDetach user value ${viewModel.user.value!!.name}")
    }

}
