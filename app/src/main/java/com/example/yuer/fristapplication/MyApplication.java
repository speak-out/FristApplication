package com.example.yuer.fristapplication;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by yuer on 2016/5/17.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader1(getApplicationContext());

    }

    /*
     * 自定义配置
     */
    public static void initImageLoader(Context context) {
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(
                context);
        config.threadPoolSize(3);//线程池内加载的数量
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();// 不缓存图片的多种尺寸在内存中
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());// 将保存的时候的URI名称用MD5
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs();// Remove for release app
        // 初始化ImageLoader
        com.nostra13.universalimageloader.core.ImageLoader.getInstance().init(config.build());
    }

    /*
     * 默认的配置，一般没有特殊的要求的时候就使用默认就好了。
     */
    public static void initImageLoader1(Context context) {
        // 创建默认的ImageLoader配置参数
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(context);
        // 初始化ImageLoader
        com.nostra13.universalimageloader.core.ImageLoader.getInstance().init(configuration);
    }
}
