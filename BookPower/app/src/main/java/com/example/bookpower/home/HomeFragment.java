package com.example.bookpower.home;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.example.bookpower.R;
import com.example.bookpower.base.BaseFragment;
import com.example.bookpower.home.bean.ResultData;
import com.example.bookpower.utils.Constarts;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * 主页面的fragment
 */
public class HomeFragment extends BaseFragment {

    private RecyclerView rv_home;
    private ImageView ib_top;
    private TextView tv_message_home;
    private TextView tv_search_home;     //实例化titlebar中的tv_search_home,在initView中获取id

    //返回的数据
    private ResultData.ResultBean resultBean;

    @Override
    public View initView() {
        Log.d("ce", "已进入主页面");
        View view = View.inflate(mContext, R.layout.fragment_home,null);  //把布局实例化给view

        rv_home = view.findViewById(R.id.rv_home);  //获取id实例化
        ib_top = view.findViewById(R.id.ib_top);
        tv_search_home = view.findViewById(R.id.tv_search_home);
        tv_message_home = view.findViewById(R.id.tv_message_home);
        Log.d("ce", "页面的fragment的UI被初始化了！");

        //设置点击事件
        initListener();
        return view;
    }

    private void initListener() {
        //设置右下角悬浮按钮的点击事件
        ib_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回到顶部
                rv_home.scrollToPosition(0);
            }
        });

        //搜索的监听事件
        tv_search_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"搜索",
                        Toast.LENGTH_SHORT).show();
            }
        });

        tv_message_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"进入消息中心",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initData(){
        super.initData();
        getDataFormNet();   //该方法调用 用于获取服务器端传来的json
        Log.d("ce", "页面的fragment的数据被初始化了！");
    }

    private void getDataFormNet() {
        OkHttpClient httpClient = new OkHttpClient();

        String url = Constarts.HOME_URL;  //使用utils中的链接
        Request getRequest = new Request.Builder()
                .url(url)
                .get()
                .build();

        Call call = httpClient.newCall(getRequest);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("ce", "onFailure: " + e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String respn = response.body().string();
                processData(respn);
//                Log.d("ce", "okHttpGet run: response:"+ response.body().string());
                Log.d("ce", "okHttpGet run: response:"+ respn);
            }
        });
    }

    private void processData(String json) {
        ResultData resultData = JSON.parseObject(json,ResultData.class);
        resultBean = resultData.getResult();
        Log.d("ce", "解析成功=="+resultBean.getAct_info().get(0).getName());
    }
}
