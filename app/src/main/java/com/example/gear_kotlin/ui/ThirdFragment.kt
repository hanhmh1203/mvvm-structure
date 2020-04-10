package com.example.gear_kotlin.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.commons.base.BaseFragment
import com.example.commons.extension.getViewModel
import com.example.commons.extension.shortToast
import com.example.gear_kotlin.R
import com.example.gear_kotlin.databinding.FragmentThirdBinding
import com.example.gear_kotlin.viewmodel.ThirdFragmentViewModel
import com.example.local.AppDatabase
import com.example.local.dao.UserDao
import com.example.remote.NewsApi
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

    //    @Inject
    lateinit var viewModel: ThirdFragmentViewModel

    lateinit var viewModel1: ThirdFragmentViewModel

    lateinit var viewModel2: ThirdFragmentViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.increaseI()
        viewModel.increaseI()
        viewModel1.increaseI()
        viewModel1.increaseI()
        viewModel2.increaseI()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = getViewModel(viewModelFactory)
        viewModel1 = getViewModel(viewModelFactory)
        viewModel2 = getViewModel(viewModelFactory)

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
//        testApi()
        viewModel.toHome.observe(viewLifecycleOwner, Observer {
            if(it){
                val  action = ThirdFragmentDirections.navToHome()
                findNavController().navigate(action)
                viewModel.toHome.value = false
            }


        })
    }

    @Inject
    lateinit var newsApi: NewsApi
    fun testApi() {
        viewModel.fetchNews("", limit = "10")
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
