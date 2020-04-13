package com.example.gear_kotlin.network

import android.util.Log
import androidx.lifecycle.*
import com.example.model.UserGit
import com.example.commons.AppDispatchers
import com.example.repository.UserGitRepository
import com.example.repository.utils.Resource
import io.philippeboisney.home.domain.GetTopUsersUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * A simple [BaseViewModel] that provide the data and handle logic to communicate with the model
 * for [HomeFragment].
 */
class HomeViewModel @Inject constructor(
    private val getTopUsersUseCase: GetTopUsersUseCase,
    private val dispatchers: AppDispatchers
) : ViewModel() {

    // FOR DATA
    private val _users = MediatorLiveData<Resource<List<UserGit>>>()
    val users: LiveData<Resource<List<UserGit>>> get() = _users
    private var usersSource: LiveData<Resource<List<UserGit>>> = MutableLiveData()

    init {
        getUsers(true)
    }

    //    // PUBLIC ACTIONS ---
    fun userClicksOnItem(user: UserGit) {

    }
    //    navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(user.login))

    fun userRefreshesItems() = getUsers(true)

    // ---


    private fun getUsers(forceRefresh: Boolean) = viewModelScope.launch(dispatchers.main) {
        _users.removeSource(usersSource) // We make sure there is only one source of livedata (allowing us properly refresh)
        withContext(dispatchers.io) {
            usersSource = getTopUsersUseCase()
        }
        _users.addSource(usersSource) {
            _users.value = it
            if (it.status == Resource.Status.ERROR) {
                Log.i("hanhmh1203", "getUsers error")
            }
        }
    }
}