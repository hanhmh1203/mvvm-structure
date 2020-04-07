package com.example.gear_kotlin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*

import com.example.commons.base.BaseFragment
import com.example.gear_kotlin.databinding.FragmentThirdBinding
import com.example.local.AppDatabase
import com.example.local.dao.UserDaoIn
import com.example.model.User
import com.example.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ThirdFragment : BaseFragment() {
    lateinit var appDb: AppDatabase
    lateinit var userDao: UserDaoIn
    lateinit var repository: UserRepository
    private lateinit var viewModel: ThirdFragmentViewModel
    private lateinit var binding: FragmentThirdBinding // generate by layout name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

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
        appDb = AppDatabase.buildDatabase(requireContext().applicationContext)
        userDao = appDb.userDao()
        repository = UserRepository(userDao)

        viewModel = ViewModelProviders.of(this).get(ThirdFragmentViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.user.observe(viewLifecycleOwner, Observer {
            Log.i("ThirdFragment", "user value ${viewModel.user.value!!.name}")
            binding.viewModel = viewModel
        })

        viewModel.viewModelScope.launch(Dispatchers.Main) {
            log("insert database")
            withContext(Dispatchers.IO){
                repository.deleteAll()
                insert()
                viewModel.users.postValue(repository.getAllUserList())
            }
        }
        viewModel.users.observe(viewLifecycleOwner, Observer { list ->
            log("viewModel.users.observe: ${list.toString()}")
            viewModel.user.value = list[0]
        })

        // TODO: Use the ViewModel
    }

    private fun insert() {
        repository.getUserDummy().forEach {
            userDao.insert(it)
        }
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
