package com.puc.telias.githubapp.models

class GitHubUser(
    val login: String,
    val avatar: String,
    val apiUrl: String,
    val htmlUrl: String,
    val reposUrl: String,
    val name: String,
    val company: String,
    val location: String,
    val bio: String,
    val repos: Int,
    val follower: Int,
    val following: Int
) {
    
}