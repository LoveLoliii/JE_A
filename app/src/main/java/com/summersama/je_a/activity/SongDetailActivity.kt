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
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.net.Uri
import android.os.Environment
import android.text.TextUtils
import com.google.gson.Gson
import com.summersama.je_a.entity.SearchSongInfo
import com.google.gson.reflect.TypeToken
import com.summersama.je_a.entity.SongDownloadInfo
import ru.noties.markwon.image.MediaDecoder
import java.io.*


class SongDetailActivity : AppCompatActivity() {
    //  val url:String = "https://s.mli.im/api/?callback=jQuery22408246496842419309_"+System.currentTimeMillis()+"&types=search&count=10&source=tencent&pages=1&name="+key+"&cache=9a94264bceaad353ef72684c2f01bb76&_="+System.currentTimeMillis()
/* 返回json结构
   [
    {
        "id": "0026EwGH2X6iP6",
        "name": "Climbing Up \"Iknimaya - The Path to Heaven\"",
        "artist": [
        "James Horner"
        ],
        "album": "Avatar (Music from the Motion Picture)",
        "pic_id": "000t7z8s0MMZSD",
        "url_id": "0026EwGH2X6iP6",
        "lyric_id": "0026EwGH2X6iP6",
        "source": "tencent"
    },
    {
        "id": "003bOJra0pKiQL",
        "name": "The Path to Hearth-Home",
        "artist": [
        "英雄联盟"
        ],
        "album": "",
        "pic_id": "001ZaCQY2OxVMg",
        "url_id": "003bOJra0pKiQL",
        "lyric_id": "003bOJra0pKiQL",
        "source": "tencent"
    },
    {
        "id": "002bvQRM07bGnu",
        "name": "The Path To Decay",
        "artist": [
        "Sirenia"
        ],
        "album": "The 13th Floor",
        "pic_id": "0023bJCl1Yg9Fz",
        "url_id": "002bvQRM07bGnu",
        "lyric_id": "002bvQRM07bGnu",
        "source": "tencent"
    },
    {
        "id": "001En2L02uR8vh",
        "name": "Avatar, Film Score Climbing Up Iknimaya/The Path to Heaven",
        "artist": [
        "James Horner"
        ],
        "album": "James Horner Flight 1955-2015",
        "pic_id": "0018GxTP3PDbyS",
        "url_id": "001En2L02uR8vh",
        "lyric_id": "001En2L02uR8vh",
        "source": "tencent"
    },
    {
        "id": "004f6QyR1UFyDM",
        "name": "The Path to Escape",
        "artist": [
        "Rob Simonsen"
        ],
        "album": "Captive State (Original Motion Picture Soundtrack)",
        "pic_id": "0046Y5hD46JYhH",
        "url_id": "004f6QyR1UFyDM",
        "lyric_id": "004f6QyR1UFyDM",
        "source": "tencent"
    },
    {
        "id": "0042kJVc2ipTHW",
        "name": "On the Path to Love",
        "artist": [
        "Saga Moon"
        ],
        "album": "Jazz Lounge Chillout",
        "pic_id": "004bQbYw24seLo",
        "url_id": "0042kJVc2ipTHW",
        "lyric_id": "0042kJVc2ipTHW",
        "source": "tencent"
    },
    {
        "id": "0036ICBp3IvTRs",
        "name": "The Path To Decay(Bonus Tracks)",
        "artist": [
        "Sirenia"
        ],
        "album": "The 13th Floor",
        "pic_id": "0023bJCl1Yg9Fz",
        "url_id": "0036ICBp3IvTRs",
        "lyric_id": "0036ICBp3IvTRs",
        "source": "tencent"
    },
    {
        "id": "002YcU1J32eRoI",
        "name": "The Path to Glory",
        "artist": [
        "Unkown Artists"
        ],
        "album": "",
        "pic_id": "001ZaCQY2OxVMg",
        "url_id": "002YcU1J32eRoI",
        "lyric_id": "002YcU1J32eRoI",
        "source": "tencent"
    },
    {
        "id": "004MzwMt2P5Vmn",
        "name": "The Path To Decay",
        "artist": [
        "Sirenia"
        ],
        "album": "The Path To Decay",
        "pic_id": "003FA1NA1dYruA",
        "url_id": "004MzwMt2P5Vmn",
        "lyric_id": "004MzwMt2P5Vmn",
        "source": "tencent"
    },
    {
        "id": "000amr7i03Wc30",
        "name": "The Path To the Infinity",
        "artist": [
        "Blue Velvet"
        ],
        "album": "Touch Me",
        "pic_id": "004W1K8445VIpG",
        "url_id": "000amr7i03Wc30",
        "lyric_id": "000amr7i03Wc30",
        "source": "tencent"
    }
    ]*/
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


        val mAnimation3 = TranslateAnimation(
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


        val mAnimation7 = TranslateAnimation(
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
        val issue: IssuesInfo = intent.getParcelableExtra("data")
        // 搜索通过关键词音乐
        var key = issue.title
        key = key.subSequence(0, key.length / 2).toString()
        Log.d(localClassName, key);
        Log.i(localClassName, issue.toString())
        asd_upload_tx.text = issue.user.login
        val url = issue.user.avatar_url
        OkHttpUtil.get(url).enqueue(
            object : Callback {
                override fun onResponse(call: Call, response: Response) {
                    val bytes = response.body()?.bytes()
                    if (bytes != null) {
                        val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                        runOnUiThread { asd_uppic_iv.setImageBitmap(bitmap) }
                    }
                }

                override fun onFailure(call: Call, e: IOException) {
                    Log.e(localClassName, e.message)
                }
            })
        val markwon = Markwon.builder(applicationContext)
            .usePlugin(ImagesPlugin.create(applicationContext)).build()
        markwon.setMarkdown(asd_body_tx, issue.body)
        val getMusicUrl: String =
            "https://s.mli.im/api/?callback=jQuery22408246496842419309_" + System.currentTimeMillis() + "&types=search&count=10&source=tencent&pages=1&name=" + key + "&cache=9a94264bceaad353ef72684c2f01bb76&_=" + System.currentTimeMillis()
        OkHttpUtil.get(getMusicUrl).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(localClassName, e.message)
            }

            override fun onResponse(call: Call, response: Response) {

                val rs: String = response.body()?.string()!!
                var s = rs
                s = s.replaceBefore("[", "")
                s = s.replaceAfterLast("]", "")
                val g: Gson = Gson()

                val type = object : TypeToken<List<SearchSongInfo>>() {

                }.type
                val list: List<SearchSongInfo> = g.fromJson(s, type)
                val getPlayUrl =
                    "https://s.mli.im/api/?callback=jQuery22408246496842419309_" + System.currentTimeMillis() + "&types=url&id=" + list[0].id + "&source=tencent&cache=9a94264bceaad353ef72684c2f01bb76&_=" + System.currentTimeMillis()
                Log.d(localClassName, s)
                OkHttpUtil.get(getPlayUrl).enqueue(object : Callback {
                    override fun onFailure(call: Call, e: IOException) {
                        Log.e(localClassName, e.message)
                    }

                    override fun onResponse(call: Call, response: Response) {
                        var rs = response.body()?.string();
                        rs = rs?.replaceBefore("{", "")
                        rs = rs?.replaceAfterLast("}", "")
                        Log.d(localClassName, rs)
                        val songDownloadInfo = g.fromJson<SongDownloadInfo>(rs, SongDownloadInfo::class.java);
                        Log.d(localClassName, songDownloadInfo.url)
                        OkHttpUtil.get(songDownloadInfo.url).enqueue(object : Callback {
                            override fun onFailure(call: Call, e: IOException) {
                                Log.e(localClassName, e.message)
                            }

                            override fun onResponse(call: Call, response: Response) {
                                //将返回结果转化为流，并写入文件
                                var inputStream: InputStream = response.body()?.byteStream()!!;
                                var `is`: InputStream? = null
                                var randomAccessFile: RandomAccessFile? = null
                                var bis: BufferedInputStream? = null
                                var buff = ByteArray(2048)

                                try {
                                    var len = 0
                                    `is` = response.body()!!.byteStream()
                                    bis = BufferedInputStream(`is`)
                                    var file = getFile()
                                    // 随机访问文件，可以指定断点续传的起始位置
                                    randomAccessFile = RandomAccessFile(file, "rwd")
                                    //randomAccessFile.seek (startsPoint);
                                    len =bis.read(buff);
                                    while ((len) != -1) {
                                        randomAccessFile!!.write(buff, 0, len)
                                    }
                                    val m:MediaPlayer = MediaPlayer.create(applicationContext, Uri.fromFile(file));
                                    m.prepare()
                                    m.start()
                                } catch (e: java.lang.Exception) {
                                }finally {
                                    try {

                                        `is`?.close()

                                        if (bis != null){
                                            bis.close();
                                        }
                                        if (randomAccessFile != null) {
                                            randomAccessFile.close();
                                        }
                                    } catch (e:Exception) {
                                        e.printStackTrace();
                                    }
                                }


                            }
                        })
                    }
                })




            }


        })
    }


    private fun getFile(): File {
        var path = ""
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED || !Environment.isExternalStorageRemovable()) {
            try {
                path = application.getExternalCacheDir().getAbsolutePath()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            if (TextUtils.isEmpty(path)) {
                path =
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath
            }
        } else {
            path = application.getCacheDir().getAbsolutePath()
        }
        return File(path + File.separator + "0.1.3" + File.separator + "sing")
    }
}




