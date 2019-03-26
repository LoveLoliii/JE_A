package com.summersama.je_a.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.summersama.je_a.data.SearchRepository
import com.summersama.je_a.entity.IssuesInfo

class SearchListViewModel internal constructor(searchRepository : SearchRepository) :ViewModel(){
    val issues:LiveData<List<IssuesInfo>> = searchRepository.getSearchList("s")

}