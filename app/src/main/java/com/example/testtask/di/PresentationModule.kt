package com.example.testtask.di

import com.example.testtask.presentation.userDetails.UserDetailsViewModel
import com.example.testtask.presentation.userList.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { UserListViewModel(get(), get()) }
    viewModel { UserDetailsViewModel(get()) }
}