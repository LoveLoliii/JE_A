package com.summersama.je_a.utils;

import android.app.Activity;
import android.util.Log;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 会存在多个函数调用client 导致响应延时。
 * @author loveloliii
 */
public class OkHttpUtil {

    private static final String TAG = OkHttpUtil.class.getCanonicalName();
    private static OkHttpClient client = new OkHttpClient();

    public OkHttpUtil(OkHttpClient client) {
        if(client == null){
        OkHttpUtil.client = client = new OkHttpClient
                .Builder()
                .connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(5 * 60 * 1000, TimeUnit.MILLISECONDS)
                .build();}
        else {
            OkHttpUtil.client =client;}
    }

    public static String get(String url,Activity activity) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("okhttp",e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    Log.e("okhttp","success");
                }
            }
        });
        return url;
    }

    public static Call get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);

        return call;
    }

    public static final MediaType Json
            = MediaType.get("application/json; charset=utf-8");
/*    public static Call postFile(File file,String url,Activity activity) {
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("img","1.jpg",RequestBody.create(MediaType.parse("image/png"),file))
                .addFormDataPart("token",PUtils.getToken(activity));
        RequestBody requestBody = builder.build();
        Request request  =new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        return call;
    }*/

    public static Call post(Map queryMap, String url, int i) {
        Gson g = new Gson();
        String queryStr = g.toJson(queryMap);
        RequestBody requestBody = RequestBody.create(Json, queryStr);
        Log.e("onClick: ", queryStr);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        client = new OkHttpClient
                .Builder()
                .connectTimeout(i * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(5 * i * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(5 * i * 1000, TimeUnit.MILLISECONDS)
                .build();
        Call call = client.newCall(request);
        return call;
    }



    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(Json, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    public static Call post(Map map,String url){
        Gson g = new Gson();
        String queryStr = g.toJson(map);
        RequestBody requestBody = RequestBody.create(Json, queryStr);
        Log.e("onClick: ", queryStr);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        return call;
    }

}
