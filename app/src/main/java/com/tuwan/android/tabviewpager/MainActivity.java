package com.tuwan.android.tabviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tuwan.android.tabviewpager.convenientbanner.ConvenientBanner;
import com.tuwan.android.tabviewpager.convenientbanner.NetworkImageHolderView;
import com.tuwan.android.tabviewpager.convenientbanner.holder.CBViewHolderCreator;
import com.tuwan.android.tabviewpager.convenientbanner.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> imageUrlList = new ArrayList<>();
    private ConvenientBanner mConvenientBanner;
    private int marginRight = 50;
    private int marginBtm = 50;

    {
        imageUrlList.add("http://pic4.nipic.com/20091113/2847083_105626034638_2.jpg");
        imageUrlList.add("http://f2.topitme.com/2/6a/bc/113109954583dbc6a2o.jpg");
        imageUrlList.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2137958015,4291978384&fm=27&gp=0.jpg");
        imageUrlList.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3102711909,683345632&fm=27&gp=0.jpg");
        imageUrlList.add("http://img0.imgtn.bdimg.com/it/u=2851272418,293470202&fm=27&gp=0.jpg");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mConvenientBanner = (ConvenientBanner) findViewById(R.id.convenientBanner);

        setBannerData(imageUrlList);

    }

    public void setBannerData(final List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        if (list.size() != 1) {
            mConvenientBanner.startTurning(3000);
            mConvenientBanner.setPointViewVisible(true);
        } else {
            mConvenientBanner.setCanLoop(false);
            mConvenientBanner.setPointViewVisible(false);
        }
        mConvenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, list)
                .setPageIndicator(new int[]{R.drawable.gallery_normal, R.drawable.gallery_select})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
                .setPageIndicatorMargin(0, 0, marginRight, marginBtm)
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {

                    }
                });
    }

}
