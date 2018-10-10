package com.francis.commonmodule.test;

import com.francis.commonmodule.base.BasePresenter;
import com.francis.commonmodule.data.TestRepository;

/**
 * Created by Francis on 2018/9/8.
 */

public class TestPresenter extends BasePresenter<ITestView> {

    public TestPresenter(ITestView view) {
        super(view);
    }

    @Override
    public void subscribe() {

    }

    public void getContent() {
        view.showContent("I am Test");
        TestRepository.getINSTANCE().getGithubService("octocat");
    }
}
