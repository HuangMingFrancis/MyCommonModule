package com.francis.commonmodule.data;

import com.francis.commonmodule.data.entity.Repo;

import java.util.List;

/**
 * Created by Francis on 2018/9/8.
 */

public interface TestDataSources {

    List<Repo> getGithubService(String user);
}
