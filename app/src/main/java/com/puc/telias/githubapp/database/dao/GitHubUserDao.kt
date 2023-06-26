package com.puc.telias.githubapp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.puc.telias.githubapp.models.GitHubUser
import kotlinx.coroutines.flow.Flow

@Dao
interface GitHubUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: GitHubUser)

    @Delete
    suspend fun destroy(user: GitHubUser)

    @Query("""SELECT * FROM git_hub_users""")
    fun getAll(): Flow<List<GitHubUser>>

    @Query("""SELECT * FROM git_hub_users WHERE login = :login""")
    suspend fun getByLogin(login: String): GitHubUser?
}