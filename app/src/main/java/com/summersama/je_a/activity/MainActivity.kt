package com.summersama.je_a.activity


import android.graphics.Color
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
import android.view.animation.LinearInterpolator
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.summersama.je_a.R
import com.summersama.je_a.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.fragment_jea.*

/**
 * 使用的首页动画来自
 *  <p> https://github.com/duldun/water-Ball</p>
 * */
class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout:DrawerLayout
    private lateinit var navController:NavController
    lateinit var adapter:SongListAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        drawerLayout = binding.drawerLayout

        navController =Navigation.findNavController(this,R.id.je_nav_fragment)
        binding.navigationView.setupWithNavController(navController)

//        setContentView(R.layout.activity_main)
       // randomWaterBallAnimation();
      //  initData()

    }
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    private fun randomWaterBallAnimation() {

        val mAnimation: TranslateAnimation
        mAnimation = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
            TranslateAnimation.RELATIVE_TO_PARENT, 1.1f,
            TranslateAnimation.RELATIVE_TO_PARENT, -0.3f
        )
        mAnimation.duration = 25000
        mAnimation.repeatCount = -1
        mAnimation.repeatMode = Animation.REVERSE
        mAnimation.interpolator = LinearInterpolator()
        water_ball.setAnimation(mAnimation)


        val mAnimation2: TranslateAnimation
        mAnimation2 = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0.0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.7f,
            TranslateAnimation.RELATIVE_TO_PARENT, 1.0f,
            TranslateAnimation.RELATIVE_TO_PARENT, -0.2f
        )
        mAnimation2.duration = 30000
        mAnimation2.repeatCount = -1
        mAnimation2.repeatMode = Animation.REVERSE
        mAnimation2.interpolator = LinearInterpolator()
        water_ball_2.setAnimation(mAnimation2)


        val mAnimation3: TranslateAnimation
        mAnimation3 = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
            TranslateAnimation.RELATIVE_TO_PARENT, 1.0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.8f
        )
        mAnimation3.duration = 25000
        mAnimation3.repeatCount = -1
        mAnimation3.repeatMode = Animation.REVERSE
        mAnimation3.interpolator = LinearInterpolator()
        water_ball_3.setAnimation(mAnimation3)


        val mAnimation4: TranslateAnimation
        mAnimation4 = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 1.0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 1.1f,
            TranslateAnimation.RELATIVE_TO_PARENT, -0.1f
        )
        mAnimation4.duration = 45000
        mAnimation4.repeatCount = -1
        mAnimation4.repeatMode = Animation.REVERSE
        mAnimation4.interpolator = LinearInterpolator()
        water_ball_4.setAnimation(mAnimation4)


        val mAnimation5: TranslateAnimation
        mAnimation5 = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0.3f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.9f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.2f,
            TranslateAnimation.RELATIVE_TO_PARENT, 1f
        )
        mAnimation5.duration = 20000
        mAnimation5.repeatCount = -1
        mAnimation5.repeatMode = Animation.REVERSE
        mAnimation5.interpolator = LinearInterpolator()
        water_ball_5.setAnimation(mAnimation5)


        val mAnimation6: TranslateAnimation
        mAnimation6 = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
            TranslateAnimation.RELATIVE_TO_PARENT, -0.1f
        )
        mAnimation6.duration = 35000
        mAnimation6.repeatCount = -1
        mAnimation6.repeatMode = Animation.REVERSE
        mAnimation6.interpolator = LinearInterpolator()
        water_ball_6.setAnimation(mAnimation6)


        val mAnimation7: TranslateAnimation
        mAnimation7 = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0.8f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.1f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.2f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.6f
        )
        mAnimation7.duration = 28000
        mAnimation7.repeatCount = -1
        mAnimation7.repeatMode = Animation.REVERSE
        mAnimation7.interpolator = LinearInterpolator()
        water_ball_7.setAnimation(mAnimation7)


        val mAnimation8: TranslateAnimation
        mAnimation8 = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
            TranslateAnimation.RELATIVE_TO_PARENT, -0.5f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.4f
        )
        mAnimation8.duration = 21000
        mAnimation8.repeatCount = -1
        mAnimation8.repeatMode = Animation.REVERSE
        mAnimation8.interpolator = LinearInterpolator()
        water_ball_8.setAnimation(mAnimation8)



        val mAnimation10: TranslateAnimation
        mAnimation10 = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0.0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.2f,
            TranslateAnimation.RELATIVE_TO_PARENT, 1f,
            TranslateAnimation.RELATIVE_TO_PARENT, -0.2f
        )
        mAnimation10.duration = 25000
        mAnimation10.repeatCount = -1
        mAnimation10.repeatMode = Animation.REVERSE
        mAnimation10.interpolator = LinearInterpolator()
        water_ball_10.setAnimation(mAnimation10)


        val mAnimation9: TranslateAnimation
        mAnimation9 = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0.4f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.3f,
            TranslateAnimation.RELATIVE_TO_PARENT, 1.2f,
            TranslateAnimation.RELATIVE_TO_PARENT, -0.1f
        )
        mAnimation9.duration = 31000
        mAnimation9.repeatCount = -1
        mAnimation9.repeatMode = Animation.REVERSE
        mAnimation9.interpolator = LinearInterpolator()
        water_ball_9.setAnimation(mAnimation9)
    }

    private fun initData() {
        val id:Int = am_query_input.context.resources.getIdentifier("android:id/search_src_text",null,null)
        val textView = am_query_input.findViewById<TextView>(id)
        textView.setTextColor(Color.parseColor("#FFFFFF"))
        am_query_input.setIconifiedByDefault(false)
        //am_query_input.isActivated
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
        //var keyword:String = am_query_input.query.toString();

    }


}
