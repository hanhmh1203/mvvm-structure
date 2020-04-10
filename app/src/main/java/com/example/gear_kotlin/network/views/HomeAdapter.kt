package com.example.gear_kotlin.network.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gear_kotlin.R
import com.example.gear_kotlin.network.HomeViewHolder
import com.example.gear_kotlin.network.HomeViewModel
import com.example.model.UserGit
import io.philippeboisney.home.views.HomeItemDiffCallback


class HomeAdapter(private val viewModel: HomeViewModel): RecyclerView.Adapter<HomeViewHolder>() {

    private val users: MutableList<UserGit> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false))

    override fun getItemCount(): Int
            = users.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int)
            = holder.bindTo(users[position], viewModel)

    // ---

    fun updateData(items: List<UserGit>) {
        val diffCallback = HomeItemDiffCallback(users, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        users.clear()
        users.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }
}