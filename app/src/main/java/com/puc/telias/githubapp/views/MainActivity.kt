package com.puc.telias.githubapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.puc.telias.githubapp.database.AppDatabase
import com.puc.telias.githubapp.databinding.ActivityMainBinding
import com.puc.telias.githubapp.databinding.AddGitHubUserDialogBinding
import com.puc.telias.githubapp.models.GitHubUser
import com.puc.telias.githubapp.repository.GitHubUsersRepository
import com.puc.telias.githubapp.webclient.GitHubUserWebClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val repository by lazy {
        GitHubUsersRepository(
            AppDatabase.getConnection(this).gitHubUserDao(),
            GitHubUserWebClient()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            val addGitHubUserDialogBinding = AddGitHubUserDialogBinding.inflate(layoutInflater)

            var userLogin = ""
            var user: GitHubUser? = null

            val alertDialog = AlertDialog.Builder(this)
                .setView(addGitHubUserDialogBinding.root)
                .setPositiveButton("Confirmar") { _, _ ->
                    lifecycleScope.launch {
                        user?.let {user ->
                            repository.addAdd(user)
                        }
                    }
                }
                .setNegativeButton("Cancelar") { _, _ ->

                }
                .create()

            alertDialog.setOnShowListener {
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)?.isEnabled = false
            }

            addGitHubUserDialogBinding.addGitHubUserDialogButton.setOnClickListener {
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)?.isEnabled = false
                lifecycleScope.launch {
                    userLogin = addGitHubUserDialogBinding.addGitHubUserDialogSearch.text.toString()
                    user = repository.getUserByLogin(userLogin)
                    user?.let {user ->
                        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)?.isEnabled = true
                        addGitHubUserDialogBinding.run {
                            addGitHubUserDialogName.text = user.name
                            addGitHubUserDialogCompany.text = user.company
                        }
                    }
                }
            }

            alertDialog.show()
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {

            }
        }
    }
}