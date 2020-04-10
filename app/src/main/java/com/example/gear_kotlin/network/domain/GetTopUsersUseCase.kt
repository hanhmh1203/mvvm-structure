package io.philippeboisney.home.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.model.UserGit
import com.example.repository.UserGitRepository
import com.example.repository.utils.Resource

/**
 * Use case that gets a [Resource][List][User] from [UserRepository]
 * and makes some specific logic actions on it.
 *
 * In this Use Case, I'm just doing nothing... ¯\_(ツ)_/¯
 */
class GetTopUsersUseCase(private val repository: UserGitRepository) {

    suspend operator fun invoke(forceRefresh: Boolean = true): LiveData<Resource<List<UserGit>>> {
        return Transformations.map(repository.getTopUsersWithCache(forceRefresh)) {
            it // Place here your specific logic actions
        }
    }
}