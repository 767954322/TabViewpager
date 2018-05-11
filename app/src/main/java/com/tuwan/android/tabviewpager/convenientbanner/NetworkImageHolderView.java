package com.tuwan.android.tabviewpager.convenientbanner;

import android.view.View;
import android.content.Context;
import android.widget.ImageView;

import com.tuwan.android.tabviewpager.GlideManager;
import com.tuwan.android.tabviewpager.R;
import com.tuwan.android.tabviewpager.convenientbanner.holder.Holder;

/**
 * Created by zhangjie on 2017/10/13.
 */
public class NetworkImageHolderView implements Holder<Object> {
    private ImageView imageView;

    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, Object obj) {
        GlideManager.glideLoader(context, obj.toString(), imageView, GlideManager.TAG_RECTANGLE, R.color.white, R.color.white, R.color.white);
    }
}
