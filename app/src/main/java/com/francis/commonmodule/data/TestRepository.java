package com.francis.commonmodule.data;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.francis.commonmodule.data.entity.Repo;
import com.francis.commonmodule.data.local.TestLocalDateSources;
import com.francis.commonmodule.data.remote.TestRemoteDataSources;

import java.util.List;

/**
 * Created by Francis on 2018/9/8.
 */

public class TestRepository implements TestDataSources{

    private final TestRemoteDataSources testRemoteDataSources;

    private final TestLocalDateSources testLocalDateSources;

    private static TestRepository INSTANCE;

    public static TestRepository getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new TestRepository();
        }
        return INSTANCE;
    }

    public TestRepository() {
        testLocalDateSources = TestLocalDateSources.getINSTANCE();
        testRemoteDataSources = TestRemoteDataSources.getINSTANCE();
    }

    @Override
    public List<Repo> getGithubService(String user) {
        testRemoteDataSources.getGithubService(user);
        return null;
    }
}
