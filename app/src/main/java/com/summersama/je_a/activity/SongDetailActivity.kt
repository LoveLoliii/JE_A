package com.summersama.je_a.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.TranslateAnimation
import com.summersama.je_a.entity.IssuesInfo
import com.summersama.je_a.utils.OkHttpUtil
import kotlinx.android.synthetic.main.activity_sing_detail.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import ru.noties.markwon.Markwon
import ru.noties.markwon.image.ImagesPlugin
import java.io.IOException
import android.graphics.BitmapFactory


class SongDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.summersama.je_a.R.layout.activity_sing_detail)
        randomWaterBallAnimation();
        initData();
    }
    private fun randomWaterBallAnimation() {

        val mAnimation = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
            TranslateAnimation.RELATIVE_TO_PARENT, 1.1f,
            TranslateAnimation.RELATIVE_TO_PARENT, -0.3f
        )
        mAnimation.duration = 25000
        mAnimation.repeatCount = -1
        mAnimation.repeatMode = Animation.REVERSE
        mAnimation.interpolator = LinearInterpolator()
        asd_water_ball.animation = mAnimation


        val mAnimation2 = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0.0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.7f,
            TranslateAnimation.RELATIVE_TO_PARENT, 1.0f,
            TranslateAnimation.RELATIVE_TO_PARENT, -0.2f
        )
        mAnimation2.duration = 30000
        mAnimation2.repeatCount = -1
        mAnimation2.repeatMode = Animation.REVERSE
        mAnimation2.interpolator = LinearInterpolator()
        asd_water_ball_2.animation = mAnimation2


        val mAnimation3  = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
            TranslateAnimation.RELATIVE_TO_PARENT, 1.0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.8f
        )
        mAnimation3.duration = 25000
        mAnimation3.repeatCount = -1
        mAnimation3.repeatMode = Animation.REVERSE
        mAnimation3.interpolator = LinearInterpolator()
        asd_water_ball_3.animation = mAnimation3


        val mAnimation4 = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 1.0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 1.1f,
            TranslateAnimation.RELATIVE_TO_PARENT, -0.1f
        )
        mAnimation4.duration = 45000
        mAnimation4.repeatCount = -1
        mAnimation4.repeatMode = Animation.REVERSE
        mAnimation4.interpolator = LinearInterpolator()
        asd_water_ball_4.animation = mAnimation4


        val mAnimation5 = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0.3f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.9f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.2f,
            TranslateAnimation.RELATIVE_TO_PARENT, 1f
        )
        mAnimation5.duration = 20000
        mAnimation5.repeatCount = -1
        mAnimation5.repeatMode = Animation.REVERSE
        mAnimation5.interpolator = LinearInterpolator()
        asd_water_ball_5.animation = mAnimation5


        val mAnimation6 = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
            TranslateAnimation.RELATIVE_TO_PARENT, -0.1f
        )
        mAnimation6.duration = 35000
        mAnimation6.repeatCount = -1
        mAnimation6.repeatMode = Animation.REVERSE
        mAnimation6.interpolator = LinearInterpolator()
        asd_water_ball_6.animation = mAnimation6


        val mAnimation7  = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0.8f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.1f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.2f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.6f
        )
        mAnimation7.duration = 28000
        mAnimation7.repeatCount = -1
        mAnimation7.repeatMode = Animation.REVERSE
        mAnimation7.interpolator = LinearInterpolator()
        asd_water_ball_7.animation = mAnimation7


        val mAnimation8 = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
            TranslateAnimation.RELATIVE_TO_PARENT, -0.5f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.4f
        )
        mAnimation8.duration = 21000
        mAnimation8.repeatCount = -1
        mAnimation8.repeatMode = Animation.REVERSE
        mAnimation8.interpolator = LinearInterpolator()
        asd_water_ball_8.animation = mAnimation8



        val mAnimation10 = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0.0f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.2f,
            TranslateAnimation.RELATIVE_TO_PARENT, 1f,
            TranslateAnimation.RELATIVE_TO_PARENT, -0.2f
        )
        mAnimation10.duration = 25000
        mAnimation10.repeatCount = -1
        mAnimation10.repeatMode = Animation.REVERSE
        mAnimation10.interpolator = LinearInterpolator()
        asd_water_ball_10.animation = mAnimation10


        val mAnimation9 = TranslateAnimation(
            TranslateAnimation.RELATIVE_TO_PARENT, 0.4f,
            TranslateAnimation.RELATIVE_TO_PARENT, 0.3f,
            TranslateAnimation.RELATIVE_TO_PARENT, 1.2f,
            TranslateAnimation.RELATIVE_TO_PARENT, -0.1f
        )
        mAnimation9.duration = 31000
        mAnimation9.repeatCount = -1
        mAnimation9.repeatMode = Animation.REVERSE
        mAnimation9.interpolator = LinearInterpolator()
        asd_water_ball_9.animation = mAnimation9
    }

    private fun initData() {
        val issue:IssuesInfo=intent.getParcelableExtra("data")
        Log.i(localClassName,issue.toString())
        asd_upload_tx.text = issue.user.login
        val url = issue.user.avatar_url
        OkHttpUtil.get(url).enqueue(object :Callback{
            override fun onResponse(call: Call, response: Response) {
                val bytes = response.body()?.bytes()
                if(bytes !=null) {
                    val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                    runOnUiThread{ asd_uppic_iv.setImageBitmap(bitmap)}
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.e(localClassName,e.message)
            }
        })
        val  markwon = Markwon.builder(applicationContext)
            .usePlugin(ImagesPlugin.create(applicationContext)).build()
        markwon.setMarkdown(asd_body_tx,issue.body)

    }
}
