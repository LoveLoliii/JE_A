package com.summersama.je_a.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.summersama.je_a.databinding.FragmentJeaBinding
import com.summersama.je_a.databinding.FragmentSongDetailBinding
import com.summersama.je_a.viewmodels.SearchListViewModel

class SearchListFragment:Fragment(){
private lateinit var viewModel: SearchListViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding =FragmentJeaBinding
        return super.onCreateView(inflater, container, savedInstanceState)

    }

}