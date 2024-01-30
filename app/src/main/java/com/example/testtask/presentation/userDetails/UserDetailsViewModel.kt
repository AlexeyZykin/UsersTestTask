package com.example.testtask.presentation.userDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtask.domain.model.UserDetails
import com.example.testtask.domain.usecase.GetUserDetailsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserDetailsViewModel(
    private val getUserDetailsUseCase: GetUserDetailsUseCase
) : ViewModel() {
    private val _userDetails = MutableLiveData<UserDetails>()
    val userDetails: LiveData<UserDetails> get() = _userDetails

    fun getUserDetails(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        _userDetails.postValue(getUserDetailsUseCase.invoke(id))
    }
}