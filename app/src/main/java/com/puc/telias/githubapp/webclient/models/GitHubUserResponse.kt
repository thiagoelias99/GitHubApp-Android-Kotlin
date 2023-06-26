package com.puc.telias.githubapp.webclient.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.puc.telias.githubapp.models.GitHubUser

class GitHubUserResponse(
    private val login: String? = null,
    private val avatar_url: String? = null,
    private val url: String? = null,
    private val html_url: String? = null,
    private val repos_url: String? = null,
    private val name: String? = null,
    private val company: String? = null,
    private val location: String? = null,
    private val bio: String? = null,
    private val public_repos: Int = 0,
    private val followers: Int = 0,
    private val following: Int = 0,

    ) {
    val gitHubUser: GitHubUser?
        get() = GitHubUser(
            login = login?.toLowerCase() ?: "",
            avatar = avatar_url ?: "",
            apiUrl = url ?: "",
            htmlUrl = html_url ?: "",
            reposUrl = repos_url ?: "",
            name = name ?: "",
            company = company ?: "",
            location = location ?: "",
            bio = bio ?: "",
            repos = public_repos,
            follower = followers,
            following = following
        )
}