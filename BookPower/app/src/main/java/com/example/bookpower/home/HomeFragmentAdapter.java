package com.example.bookpower.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookpower.R;
import com.example.bookpower.home.bean.ResultData;
import com.youth.banner.Banner;

import java.util.List;

public class HomeFragmentAdapter extends RecyclerView.Adapter {

    //横幅广告类型
    public static final int BANNER = 0;

    //分类类型
    public static final int CHANNEL = 1;

    //活动类型
    public static final int  ACT = 2;

    //秒杀类型
    public static final int SECKILL = 3;

    //推荐类型
    public static final int RECOMMEND = 4;

    //热卖类型
    public static final int HOT = 5;

    //初始化页面中的子布局
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private ResultData.ResultBean resultBean;   //需要的数据

    //获取当前的类型
    private int currentType = BANNER;

    public HomeFragmentAdapter(Context mContext,ResultData.ResultBean resultBean){
        this.mContext = mContext;
        this.resultBean = resultBean;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    /**
     * 相当于getView创建ViewHolder部分代码
     * 创建ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //如果是BANNER类型
        if (viewType == BANNER){
            return new BannerViewHolder(mContext,mLayoutInflater.
                    inflate(R.layout.banner_viewpager,null));
        }
        return null;
    }

    /**
     * 给 getView 绑定数据的模块
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == BANNER){   //这里通过position参数判断是否获得BANNER，然后在传数据
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;//如果不绑定数据的话，是不会显示的
            bannerViewHolder.setData(resultBean.getBanner_info());//用于获取Banner_info在setData中设置数据
        }
    }

    class BannerViewHolder extends RecyclerView.ViewHolder{

        private Context mContext;   //获取banner等
        private View view;
        private Banner banner;

        public BannerViewHolder(Context mContext, View view) {
            super(view);
            this.mContext = mContext;
            //实例化banner
            this.banner = view.findViewById(R.id.banner);
        }

        public void setData(List<ResultData.ResultBean.BannerInfoBean> banner_info) {
            //设置banner的数据
            Object imageUrl = null;
        }
    }

    /**
     * 用于得到 类型
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        switch (position){
            case BANNER:
                currentType = BANNER;
                break;
            case CHANNEL:
                currentType = CHANNEL;
                break;
            case ACT:
                currentType = ACT;
                break;
            case SECKILL:
                currentType = SECKILL;
                break;
            case RECOMMEND:
                currentType = RECOMMEND;
                break;
            case HOT:
                currentType = HOT;
                break;
        }
        return currentType;
    }

    /**
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return 1;    //返回的数值代表当前使用了多少个类型，如果只有一个类型就写1
    }
}
