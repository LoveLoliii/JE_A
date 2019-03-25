/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.summersama.je_a.fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.summersama.je_a.adapter.JESearchAdapter
import com.summersama.je_a.databinding.FragmentJeaBinding


class JEAFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentJeaBinding.inflate(inflater, container, false)
        val adapter = JESearchAdapter()
       // binding.amRecycleView.adapter = adapter
        subscribeUi(adapter, binding)
        return binding.root
    }

    private fun subscribeUi(adapter: JESearchAdapter, binding: FragmentJeaBinding) {
    //    val factory = InjectorUtils.provideGardenPlantingListViewModelFactory(requireContext())
     //   val viewModel = ViewModelProviders.of(this, factory)
      //      .get(JESearchListViewModel::class.java)

       // viewModel.gardenPlantings.observe(viewLifecycleOwner, Observer { plantings ->
       //     binding.hasPlantings = !plantings.isNullOrEmpty()
      //  })

      //  viewModel.plantAndGardenPlantings.observe(viewLifecycleOwner, Observer { result ->
      //      if (!result.isNullOrEmpty())
        //        adapter.submitList(result)
      //  })
    }
}
