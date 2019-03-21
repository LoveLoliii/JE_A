package com.summersama.je_a

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson
import com.summersama.je_a.adapter.SongListAdapter
import com.summersama.je_a.entity.SearchInfo
import com.summersama.je_a.utils.ConstantUtils
import com.summersama.je_a.utils.OkHttpUtil

import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager



class MainActivity : AppCompatActivity() {
    lateinit var adapter:SongListAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()


    }

    private fun initData() {
        am_query_input.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {

                Toast.makeText(applicationContext,newText,Toast.LENGTH_SHORT).show();
                 return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                var url = ConstantUtils.QUERY_URL + "&q="+query+"+state:open+repo:zytx121/je"
                val call = OkHttpUtil.get(url)
                Log.i(localClassName,url)
                call.enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        Log.i(localClassName, e.message)
                    }

                    override fun onResponse(call: Call, response: Response) {
                        val result:String? = response.body()?.string();
                        var g = Gson();
                        var searchInfo: SearchInfo
                        searchInfo = g.fromJson(result,SearchInfo::class.java)
                        runOnUiThread {
                            adapter = SongListAdapter(searchInfo.items, applicationContext)
                            val layoutManager = object : LinearLayoutManager(applicationContext) {
                                override fun onLayoutChildren(
                                    recycler: RecyclerView.Recycler?,
                                    state: RecyclerView.State
                                ) {
                                    super.onLayoutChildren(recycler, state)
                                }
                            }
                            layoutManager.orientation = RecyclerView.VERTICAL
                            am_recycle_view.setLayoutManager(layoutManager)
                            am_recycle_view.setAdapter(adapter)
                            Log.i(localClassName, searchInfo.toString());
                        }

                    }

                })
                return false
            }

        })
        var keyword:String = am_query_input.query.toString();

    }


}
