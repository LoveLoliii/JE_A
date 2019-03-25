package com.summersama.je_a.adapter

import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.summersama.je_a.entity.IssuesInfo

class JESearchAdapter :ListAdapter<IssuesInfo,JESearchAdapter.ViewHolder>(JEADiffCallBack()){
    class ViewHolder(private val binding:){

    }

}

private class JEADiffCallBack : DiffUtil.ItemCallback<IssuesInfo>(){
    override fun areItemsTheSame(
        oldItem: IssuesInfo,
        newItem: IssuesInfo
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: IssuesInfo,
        newItem: IssuesInfo
    ): Boolean {
        return oldItem.id == newItem.id
    }
}
