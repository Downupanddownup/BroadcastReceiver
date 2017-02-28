package com.example.hopjs.broadcastreceiver;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
/*目的：了解广播的两种注册方法
* 结果：
* 1，静态注册
* 创建自定义广播接收器
* 重写接受方法
* 在配置文件中进行注册
* 2，动态注册
* 创建自定义广播接收器并重写接受方法
* 创建广播过滤器，并添加过滤标志符
* 实例化广播接收器
* 注册广播
* 在需要时接触注册*/
    IntentFilter filter;
    AnotherApplicationMsg applicationMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filter = new IntentFilter();
        filter.addAction("com.example.MY_BROADCASTMSG");
        applicationMsg = new AnotherApplicationMsg();
        registerReceiver(applicationMsg,filter);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msg = new Intent("com.example.MY_BROADCASTMSG");
                msg.putExtra("msg","hello");
                sendBroadcast(msg);
            }
        });

        String path = "";
        /*getFilesDir
        * getCacheDir
        * getDir
        * getExternalCacheDir
        * getExternalFilesDir
        * getDatabasePath
        * getPackageCodePath
        * getPackageResourcePath
        * getObbDir*/
        path += "\r\n getFilesDir:"+getFilesDir().getPath()+"\n";
        path += "getCacheDir:"+getCacheDir().getPath()+"\n";
        path += "getDir:"+getDir("test.txt", Context.MODE_WORLD_WRITEABLE).getPath()+"\n";
        path += "getExternalCacheDir:"+getExternalCacheDir().getPath()+"\n";
        path += "getExternalFilesDir:"+getExternalFilesDir("/").getPath()+"\n";
        path += "getExternalFilesDir:"+getExternalFilesDir("Environment.DIRECTORY_PICTURES").getPath()+"\n";
//        path += getDatabasePath("").getPath()+"";
        path += "getPackageCodePath:"+getPackageCodePath()+"\n";
        path += "getPackageResourcePath:"+getPackageResourcePath()+"\n";
        path += "getObbDir:"+getObbDir().getPath()+"\n";
        Log.i("getPath",path);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(applicationMsg);
    }
}
