package com.example.gear_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.core.UserModel
import com.example.gear_kotlin.base.BaseFragment

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AppFirstFragment : BaseFragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.app_fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val param1 = 101
        val param2 = this::class.java.name
        val user= UserModel(userName = "hanhmh1203")
        val  action = AppFirstFragmentDirections.actionFirstFragmentToSecondFragment().setParamInt(param1).setParamStr(param2).setParamObject(user)
        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(action)
        }
    }

}
