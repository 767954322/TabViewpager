package com.tuwan.android.tabviewpager;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by gumenghao on 2018/5/7.
 */

public class GlideManager {

    /**
     * //1.app统一默认图
     * GlideManager.glideLoader(MainActivity.this, imageUrl, ivTest, GlideManager.TAG_ROUND);
     * //2.自定义默认图
     * GlideManager.glideLoader(MainActivity.this, imageUrl, ivTest, GlideManager.TAG_ROUND,R.mipmap.ic_launcher,R.mipmap.ic_launcher, R.color.colorAccent);
     **/

    //app统一默认图
    public static void glideLoader(Context context, String url, ImageView iv, int tag) {

        if (tag == TAG_RECTANGLE) {

            Glide.with(context).load(url).apply(rectangleOptions).into(iv);

        } else if (tag == TAG_ROUND) {

            Glide.with(context).load(url).apply(roundOptions).into(iv);

        } else if (tag == TAG_FILLET) {

            Glide.with(context).load(url).apply(filletOptions).into(iv);

        }

    }

    //自定义默认图
    public static void glideLoader(Context context, String url, ImageView iv, int tag, int loadingImg, int erroImg, int emptyImg) {

        RequestOptions options = new RequestOptions()
                .placeholder(loadingImg)
                .error(erroImg)
                .fallback(emptyImg)
                .centerCrop()
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);

        if (tag == TAG_ROUND) {

            options.transform(new CircleCrop());

        } else if (tag == TAG_FILLET) {

            options.transform(new RoundedCorners(8));

        }

        Glide.with(context).load(url).apply(options).into(iv);

    }


    //矩形
    public static final int TAG_RECTANGLE = 0;
    public static RequestOptions rectangleOptions = new RequestOptions()
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .fallback(R.mipmap.ic_launcher)
            .centerCrop()
            .priority(Priority.HIGH)
            .diskCacheStrategy(DiskCacheStrategy.ALL);

    //圆形
    public static final int TAG_ROUND = 1;
    public static RequestOptions roundOptions = new RequestOptions()
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .fallback(R.mipmap.ic_launcher)
            .centerCrop()
            .transform(new CircleCrop())
            .priority(Priority.HIGH)
            .diskCacheStrategy(DiskCacheStrategy.ALL);

    //圆角
    public static final int TAG_FILLET = 2;
    public static RequestOptions filletOptions = new RequestOptions()
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .fallback(R.mipmap.ic_launcher)
            .centerCrop()
            .transform(new RoundedCorners(8))
            .priority(Priority.HIGH)
            .diskCacheStrategy(DiskCacheStrategy.ALL);

}
