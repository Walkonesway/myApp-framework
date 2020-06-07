package com.example.bookpower.collect;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.bookpower.base.BaseFragment;


/**
 * 我的收藏页面的fragment
 */
public class CollectFragment extends BaseFragment {

    private TextView textView;
    @Override
    public View initView() {
        Log.d("ce", "我的收藏页面的fragment的UI被初始化了！");
        textView = new TextView(mContext);
        textView.setText("我的收藏页内容");
        textView.setGravity(Gravity.CENTER);   //居中对齐
        textView.setTextSize(25);
        textView.setTextColor(Color.RED);
        return textView;
    }

    public void initData(){
        super.initData();
        Log.d("ce", "我的收藏页面的fragment的数据被初始化了！");
        textView.setText("我的收藏页的内容");
    }
}
