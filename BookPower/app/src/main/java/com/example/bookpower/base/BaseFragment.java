package com.example.bookpower.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 基类fragment
 * 首页HomeFragment
 * 我的收藏CollectFragment
 * 图书BooksFragment
 * 个人信息MeFragment
 * 都需要继承这个类
 */
public abstract class BaseFragment extends Fragment {
    public Context mContext;   //上下文

    /**
     * 创建改类时回调函数
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }


    /**
     * 创建视图
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    /**
     * 抽象类，由孩子实现
     * @return
     */
    public abstract View initView();    //抽象方法，对应改类必须为抽象的


    /**
     * 当Activity被创建时回调这个方法
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
    }

    public void initData() {
    }

    /**
     * 当子类需要联网请求数据时，可以重写这个方法，在该方法中联网请求
     */

}
