package com.summersama.je_a.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.summersama.je_a.entity.IssuesInfo

class SearchRepository {
    fun getSearchList(key: String): LiveData<List<IssuesInfo>> {
        val y : List<IssuesInfo> =ArrayList<IssuesInfo>()
        val x:LiveData<List<IssuesInfo>> = MutableLiveData()
        return x;
    }

    companion object {
        @Volatile
        private var instance: SearchRepository? = null
        fun getInstance() = {
            instance ?: synchronized(this) {
                instance ?: SearchRepository().also { instance = it }
            }
        }
    }
}