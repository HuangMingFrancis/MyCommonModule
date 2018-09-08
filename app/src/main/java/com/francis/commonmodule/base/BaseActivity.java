package com.francis.commonmodule.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Francis on 2018/9/8.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected T basePresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

        this.basePresenter = initPresenter();

        initView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (basePresenter != null){
            basePresenter.subscribe();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (basePresenter != null){
            basePresenter.unsubscribe();
        }
    }

    protected abstract int getContentView();

    protected abstract T initPresenter();

    protected abstract void initView();
}
