package com.puc.telias.githubapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "git_hub_users")
data class GitHubUser(
    @PrimaryKey val login: String,
    val avatar: String,
    @ColumnInfo(name = "api_url") val apiUrl: String,
    @ColumnInfo(name = "html_url")val htmlUrl: String,
    @ColumnInfo(name = "repos_url")val reposUrl: String,
    val name: String,
    val company: String,
    val location: String,
    val bio: String,
    val repos: Int,
    val follower: Int,
    val following: Int
) {

}