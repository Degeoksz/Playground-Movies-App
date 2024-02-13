package com.example.playgroundmoviesapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playgroundmoviesapp.usecase.AuthenticateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val authenticateUseCase: AuthenticateUseCase
): ViewModel() {
    init {
        viewModelScope.launch {
            authenticateUseCase()
        }
    }
}
