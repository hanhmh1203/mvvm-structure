package com.example.gear_kotlin.network

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.gear_kotlin.databinding.ItemHomeBinding
import com.example.model.UserGit


class HomeViewHolder(parent: View): RecyclerView.ViewHolder(parent) {

    private val binding = ItemHomeBinding.bind(parent)

    fun bindTo(user: UserGit, viewModel: HomeViewModel) {
        binding.user = user
        binding.viewmodel = viewModel
    }
}