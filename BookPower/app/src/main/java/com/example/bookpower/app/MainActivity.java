package com.example.bookpower.app;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.bookpower.R;
import com.example.bookpower.base.BaseFragment;
import com.example.bookpower.books.BooksFragment;
import com.example.bookpower.collect.CollectFragment;
import com.example.bookpower.home.HomeFragment;
import com.example.bookpower.me.MeFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;
    @BindView(R.id.bt_main)
    RadioButton btMain;
    @BindView(R.id.bt_collect)
    RadioButton btCollect;
    @BindView(R.id.bt_books)
    RadioButton btBooks;
    @BindView(R.id.bt_me)
    RadioButton btMe;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    private int position = 0;


    /**
     * 装多个fragment
     */
    private ArrayList<BaseFragment> fragments;

    //缓存的或上次显示的fragment
    private Fragment tempFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Log.d("ce", "主函数第1步");
        /**
         * 初始化fragment
         */
        initFragment();

        initListener();
    }

    private void initListener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("ce", "主函数调用initListener");
                switch (checkedId) {
                    case R.id.bt_main:
                        Log.d("ce", "选中第1个页面");
                        position = 0;    //主页
                        break;
                    case R.id.bt_collect:
                        Log.d("ce", "选中第2个页面");
                        position = 1;    //我的收藏页
                        break;
                    case R.id.bt_books:
                        Log.d("ce", "选中第3个页面");
                        position = 2;    //书籍信息页
                        break;
                    case R.id.bt_me:
                        Log.d("ce", "选中第4个页面");
                        position = 3;     //我的信息页
                        break;
                    default:
                        position = 0;     //默认为首页
                        break;
                }

                //根据位置取不同的fragment
                BaseFragment baseFragment = getFragment(position);  //调用getFragment方法

                /**
                 * 第一个参数：上次显示的fragment，已经缓存
                 * 第二个参数：当前正要显示的fragment
                 */
                switchFragment(tempFragment, baseFragment);
            }
        });
        rgMain.check(R.id.bt_main);  //？？？？？？？？
    }

    /**
     * 按顺序添加
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CollectFragment());
        fragments.add(new BooksFragment());
        fragments.add(new MeFragment());
    }


    private BaseFragment getFragment(int position) {
        Log.d("ce", "获取fragmen");
        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }


    /**
     * 切换fragment
     *
     * @param fromFragment
     * @param nextFragment
     */
    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
        Log.d("ce", "切换页面");
        if (tempFragment != nextFragment) {
            tempFragment = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前的fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.frameLayout, nextFragment).commit();
                } else {
                    //隐藏当前的fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }
}
