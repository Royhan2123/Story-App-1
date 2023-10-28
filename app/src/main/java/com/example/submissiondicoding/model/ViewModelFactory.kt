package com.example.submissiondicoding.model
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.submissiondicoding.api.StoryRepository
import com.example.submissiondicoding.preferences.UserPreference

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: StoryRepository, private val pref: UserPreference) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            LogoutViewModel::class.java -> LogoutViewModel(pref) as T
            SignupViewModel::class.java -> SignupViewModel(repository) as T
            MainViewModel::class.java -> MainViewModel(repository) as T
            LoginViewModel::class.java -> LoginViewModel(repository, pref) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}
