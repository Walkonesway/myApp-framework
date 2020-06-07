package com.example.bookpower.books;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.bookpower.base.BaseFragment;


/**
 * 图书信息页面的fragment
 */
public class BooksFragment extends BaseFragment {

    private TextView textView;
    @Override
    public View initView() {
        Log.d("ce", "图书信息页面的fragment的UI被初始化了！");
        textView = new TextView(mContext);
        textView.setText("图书信息页内容");
        textView.setGravity(Gravity.CENTER);   //居中对齐
        textView.setTextSize(25);
        return textView;
    }

    public void initData(){
        super.initData();
        Log.d("ce", "图书信息页面的fragment的数据被初始化了！");
        textView.setText("图书信息页的内容");
    }
}