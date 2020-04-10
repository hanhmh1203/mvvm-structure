package io.philippeboisney.home.views

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import com.example.gear_kotlin.network.views.HomeAdapter
import com.example.model.UserGit
import com.example.repository.utils.Resource


object HomeBinding {

    @BindingAdapter("app:showWhenLoading")
    @JvmStatic
    fun <T>showWhenLoading(view: SwipeRefreshLayout, resource: Resource<T>?) {
        Log.d(HomeBinding::class.java.simpleName, "Resource: $resource")
        if (resource != null) view.isRefreshing = resource.status == Resource.Status.LOADING
    }

    @BindingAdapter("app:items")
    @JvmStatic fun setItems(recyclerView: RecyclerView, resource: Resource<List<UserGit>>?) {
        with(recyclerView.adapter as HomeAdapter) {
            resource?.data?.let { updateData(it) }
        }
    }

    @BindingAdapter("app:imageUrl")
    @JvmStatic fun loadImage(view: ImageView, url: String) {
//        Glide.with(view.context).load(url).apply(RequestOptions.circleCropTransform()).into(view)
    }

    @BindingAdapter("app:showWhenEmptyList")
    @JvmStatic fun showMessageErrorWhenEmptyList(view: View, resource: Resource<List<UserGit>>?) {
        if (resource!=null) {
            view.visibility = if (resource.status == Resource.Status.ERROR
                && resource.data != null
                && resource.data!!.isEmpty()) View.VISIBLE else View.GONE
        }
    }
}