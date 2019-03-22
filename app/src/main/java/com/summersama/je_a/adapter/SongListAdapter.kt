package com.summersama.je_a.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.summersama.je_a.activity.SongDetailActivity
import com.summersama.je_a.R
import com.summersama.je_a.entity.IssuesInfo

class SongListAdapter(val list:List<IssuesInfo>, val ctx: Context) :
    RecyclerView.Adapter<SongListAdapter.SongHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false);
        return SongHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SongHolder, position: Int) {
        holder.textView.text = list[position].title
      //  holder.bodyTx.setText(list[position].body)
        holder.textView.setOnClickListener{
            val intent:Intent=Intent()
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.setClass(ctx,SongDetailActivity::class.java)
            intent.putExtra("data",list[position])
            ctx.startActivity(intent)
        }
    }

    class SongHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView:TextView = itemView.findViewById(R.id.rvi_title_tx)
      //  val bodyTx:TextView = itemView.findViewById(R.id.rvi_body_tx)
    }

}