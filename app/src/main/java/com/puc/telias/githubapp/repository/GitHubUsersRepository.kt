package com.puc.telias.githubapp.repository

import com.puc.telias.githubapp.database.dao.GitHubUserDao
import com.puc.telias.githubapp.models.GitHubUser
import com.puc.telias.githubapp.webclient.GitHubUserWebClient

class GitHubUsersRepository(
    private val dao: GitHubUserDao,
    private val webClient: GitHubUserWebClient
) {
    suspend fun getUserByLogin(login: String): GitHubUser?{
        return webClient.getGitHubUserByLogin(login) ?: null
    }



}