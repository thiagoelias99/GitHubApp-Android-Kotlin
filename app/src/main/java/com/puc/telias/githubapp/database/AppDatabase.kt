package com.puc.telias.githubapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.puc.telias.githubapp.database.dao.GitHubUserDao
import com.puc.telias.githubapp.models.GitHubUser

@Database(entities = [GitHubUser::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gitHubUserDao(): GitHubUserDao

    companion object {
        fun getConnection(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "weatherapp.db"
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}