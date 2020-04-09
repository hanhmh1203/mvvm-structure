package com.example.gear_kotlin.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.commons.base.BaseFragment
import com.example.commons.extension.shortToast
import com.example.gear_kotlin.databinding.FragmentThirdBinding
import com.example.gear_kotlin.viewmodel.ThirdFragmentViewModel
import com.example.local.AppDatabase
import com.example.local.dao.UserDao
import com.example.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ThirdFragment : BaseFragment() {
    @Inject
    lateinit var repository: UserRepository


    private lateinit var binding: FragmentThirdBinding // generate by layout name

    /*
   * Step 1: Here, we need to inject the ViewModelFactory.
   * */
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var viewModel: ThirdFragmentViewModel



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
        viewModel = ViewModelProvider(this, viewModelFactory).get(ThirdFragmentViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.user.observe(viewLifecycleOwner, Observer {
            Log.i("ThirdFragment", "user value ${viewModel.user.value!!.name}")
            binding.viewModel = viewModel
        })

        viewModel.users.observe(viewLifecycleOwner, Observer { list ->
            log("viewModel.users.observe: ${list.toString()}")
            viewModel.user.value = list[0]
        })

        // TODO: Use the ViewModel
    }



    override fun onStop() {
        super.onStop()
        Log.i("ThirdFragment", "onStop user value ${viewModel.user.value!!.name}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ThirdFragment", " onDestroy user value ${viewModel.user.value!!.name}")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("ThirdFragment", " onDetach user value ${viewModel.user.value!!.name}")
    }

}
