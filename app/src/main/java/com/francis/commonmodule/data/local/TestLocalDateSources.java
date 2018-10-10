package com.francis.commonmodule.data.local;

import com.francis.commonmodule.data.TestDataSources;
import com.francis.commonmodule.data.entity.Repo;
import com.francis.commonmodule.data.remote.TestRemoteDataSources;

import java.util.List;

/**
 * Created by Francis on 2018/9/8.
 */

public class TestLocalDateSources implements TestDataSources{

    private static TestLocalDateSources INSTANCE;

    public static TestLocalDateSources getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new TestLocalDateSources();
        }
        return INSTANCE;
    }

    @Override
    public List<Repo> getGithubService(String user) {
        return null;
    }
}
