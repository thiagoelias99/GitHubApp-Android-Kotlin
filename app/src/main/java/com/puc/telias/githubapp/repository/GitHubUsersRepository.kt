package com.puc.telias.githubapp.repository

import android.util.Log
import com.puc.telias.githubapp.database.dao.GitHubUserDao
import com.puc.telias.githubapp.models.GitHubUser
import com.puc.telias.githubapp.webclient.GitHubUserWebClient

class GitHubUsersRepository(
    private val dao: GitHubUserDao,
    private val webClient: GitHubUserWebClient
) {
    private val TAG = "GitHubUsersRepository"
    suspend fun getUserByLogin(login: String): GitHubUser?{
        val userDB = dao.getByLogin(login)
        Log.i(TAG, "getUserByLogin: $userDB")
        return dao.getByLogin(login) ?: webClient.getGitHubUserByLogin(login)
    }

    suspend fun addAdd(user: GitHubUser){
        dao.insert(user)
    }
}