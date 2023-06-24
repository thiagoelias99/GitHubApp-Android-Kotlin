package com.puc.telias.githubapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.puc.telias.githubapp.R
import com.puc.telias.githubapp.webclient.GitHubUserWebClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val webClient by lazy {
        GitHubUserWebClient()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val user = webClient.getGitHubUserByLogin("thiagoelias99")
            Log.i(TAG, "GitHub User: $user.")
            repeatOnLifecycle(Lifecycle.State.STARTED) {

            }
        }
    }
}