package com.summersama.je_a.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.summersama.je_a.data.Issues
import com.summersama.je_a.databinding.RecyclerViewItemBinding

class JESearchAdapter :ListAdapter<Issues,JESearchAdapter.ViewHolder>(JEADiffCallBack()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val issues = getItem(position)
        holder.apply {
            bind(createOnClickListener(issues.title), issues)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecyclerViewItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    class ViewHolder(private val binding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, item: Issues) {
            binding.apply {
                clickListener = listener
                issues = item
                executePendingBindings()
            }
        }
    }

    private fun createOnClickListener(plantId: String): View.OnClickListener {
        return View.OnClickListener {
            // val direction = PlantListFragmentDirections.actionPlantListFragmentToPlantDetailFragment(plantId)
            // it.findNavController().navigate(direction)
        }


    }
}
private class JEADiffCallBack : DiffUtil.ItemCallback<Issues>(){
    override fun areItemsTheSame(
        oldItem: Issues,
        newItem: Issues
    ): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(
        oldItem: Issues,
        newItem: Issues
    ): Boolean {
        return oldItem.title == newItem.title
    }
}
