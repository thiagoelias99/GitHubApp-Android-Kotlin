package com.puc.telias.githubapp.webclient

import android.util.Log
import com.puc.telias.githubapp.models.GitHubUser
import com.puc.telias.githubapp.webclient.models.GitHubUserResponse
import com.puc.telias.githubapp.webclient.services.GitHubUserService

class GitHubUserWebClient {
    private val TAG = "NotaWebClient"
    private val gitHubUserService: GitHubUserService = RetrofitConfig().gitHubUserService

    suspend fun getGitHubUserByLogin(gitHubUserLogin: String): GitHubUser? {
        return (
                try {
                    val response = gitHubUserService.getUserByLogin(gitHubUserLogin)
                    response.body()?.let { it.gitHubUser }
                } catch (e: Exception) {
                    Log.e(TAG, "getGitHubUserByLogin: ", e)
                    null
                }
                )
    }
}