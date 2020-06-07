package com.example.bookpower.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.bookpower.R;


public class Welcome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Log.d("ce", "进入欢迎界面");

        //5秒进入主界面
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //执行在主线程
                //跳转到主界面
                startActivity(new Intent(Welcome.this, MainActivity.class));

                //关闭当前页面
                finish();
            }
        },3000);
    }
}
