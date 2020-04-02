package com.example.gear_kotlin

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class FragmentWithViewmodel : Fragment() {

    companion object {
        fun newInstance() = FragmentWithViewmodel()
    }

    private lateinit var viewModel: FragmentWithViewmodelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_with_viewmodel_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FragmentWithViewmodelViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
