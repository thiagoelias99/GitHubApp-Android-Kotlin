package com.puc.telias.githubapp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.puc.telias.githubapp.models.GitHubUser

@Dao
interface GitHubUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: GitHubUser)

    @Delete
    suspend fun destroy(user: GitHubUser)

    //@Query()
}