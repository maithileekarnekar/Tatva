package com.androidwavelength.tatva.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory<T : ViewModel>(
    private val viewModelClass: Class<T>,
    private val repository: Any
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModelClass)) {
            return viewModelClass.getConstructor(repository::class.java).newInstance(repository)
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

