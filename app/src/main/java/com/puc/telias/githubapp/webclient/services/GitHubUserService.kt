package com.puc.telias.githubapp.webclient.services

import com.puc.telias.githubapp.webclient.models.GitHubUserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubUserService {

    @GET("{userLogin}")
    suspend fun getUserByLogin(@Path("userLogin") userLogin: String): Response<GitHubUserResponse>
}