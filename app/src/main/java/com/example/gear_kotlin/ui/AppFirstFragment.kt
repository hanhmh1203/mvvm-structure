package com.example.gear_kotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.commons.base.BaseFragment
import com.example.gear_kotlin.R
import com.example.model.User


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
        val user= User(name = "hanhmh1203")
        val  action = AppFirstFragmentDirections.actionFirstFragmentToSecondFragment(user).setParamInt(param1).setParamStr(param2)
        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(action)
        }
    }

}
