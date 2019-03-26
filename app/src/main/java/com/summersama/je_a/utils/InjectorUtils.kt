package com.summersama.je_a.utils

import android.content.Context
import com.summersama.je_a.data.SearchRepository
import com.summersama.je_a.viewmodels.SearchListViewModelFactory

object InjectorUtils {
    fun provideSearchListViewModelFactory(ctx: Context): SearchListViewModelFactory {
        val repository = SearchRepository.getInstance()
       return SearchListViewModelFactory(kotlin.run(repository))
    }

}
