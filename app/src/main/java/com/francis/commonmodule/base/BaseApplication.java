package com.francis.commonmodule.base;

import android.app.Application;

import com.francis.commonmodule.net.NetWorkManager;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by Francis on 2018/9/19.
 */

public class BaseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        initLog();
        initRetrofit();
    }

    private void initRetrofit() {
        NetWorkManager.getInstance().init();
    }

    private void initLog() {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
