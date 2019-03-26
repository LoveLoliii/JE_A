package com.summersama.je_a.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.summersama.je_a.data.SearchRepository

class SearchListViewModelFactory(
    private val repository: SearchRepository
): ViewModelProvider.NewInstanceFactory(){
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = SearchListViewModel(repository) as T
}