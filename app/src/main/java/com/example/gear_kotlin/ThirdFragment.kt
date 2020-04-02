package com.example.gear_kotlin

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.core.UserModel
import com.example.gear_kotlin.base.BaseFragment


class ThirdFragment : BaseFragment() {

    companion object {
        fun newInstance() = ThirdFragment()
    }

    private lateinit var viewModel: ThirdFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ThirdFragmentViewModel::class.java)
        viewModel.user.value = UserModel("hanhmh1203")
        viewModel.user.observe(viewLifecycleOwner, Observer {
            Log.i("ThirdFragment","user value ${viewModel.user.value!!.userName}")
        })

        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var increase =0
        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            increase++
//            viewModel.setUserNameWithOut("hanhmh1203 $increase")
            viewModel.setUserName("hanhmh1203 $increase")
        }
    }

    override fun onStop() {
        super.onStop()
        Log.i("ThirdFragment","onStop user value ${viewModel.user.value!!.userName}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ThirdFragment"," onDestroy user value ${viewModel.user.value!!.userName}")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("ThirdFragment"," onDetach user value ${viewModel.user.value!!.userName}")
    }

}
