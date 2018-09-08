package com.francis.commonmodule.test;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.francis.commonmodule.R;
import com.francis.commonmodule.base.BaseActivity;

public class TestActivity extends BaseActivity<TestPresenter> implements ITestView, View.OnClickListener{
    private TextView tvTest;
    private Button btnTest;


    @Override
    protected int getContentView() {
        return R.layout.activity_test;
    }

    @Override
    protected TestPresenter initPresenter() {
        return new TestPresenter(this);
    }

    @Override
    protected void initView() {
        tvTest = findViewById(R.id.tv_test);
        btnTest = findViewById(R.id.btn_test);
        btnTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test:
                basePresenter.getContent();
                break;
        }
    }

    @Override
    public void showContent(String content) {
        tvTest.setText(content);
    }
}
