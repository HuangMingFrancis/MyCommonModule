package com.francis.commonmodule.data.remote;

import android.util.Log;

import com.francis.commonmodule.data.TestDataSources;
import com.francis.commonmodule.data.entity.Repo;
import com.francis.commonmodule.net.GitHubService;
import com.francis.commonmodule.net.NetWorkManager;
import com.francis.commonmodule.net.okhttp.LogInterceptor;
import com.francis.commonmodule.utils.rx.RxJavaUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.internal.cache.CacheInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Francis on 2018/9/8.
 */

public class TestRemoteDataSources implements TestDataSources {
    private static final String TAG = "TestRemoteDataSources";
    private static TestRemoteDataSources INSTANCE;

    public static TestRemoteDataSources getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new TestRemoteDataSources();
        }
        return INSTANCE;
    }

    @Override
    public List<Repo> getGithubService(String user) {

        GitHubService service = NetWorkManager.getInstance().getRetrofit("https://api.github.com/")
                .create(GitHubService.class);
        service.listRepos(user)
                .compose(RxJavaUtils.observableToMain())
                .subscribe(new Consumer<List<Repo>>() {
                    @Override
                    public void accept(List<Repo> repos) throws Exception {
                        Log.i(TAG, "onResponse: ");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i(TAG, "onFailure: ");
                    }
                });

//        Call<List<Repo>> repos = service.listRepos(user);
//        repos.enqueue(new Callback<List<Repo>>() {
//            @Override
//            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
//                Log.i(TAG, "onResponse: ");
//            }
//
//            @Override
//            public void onFailure(Call<List<Repo>> call, Throwable t) {
//                Log.i(TAG, "onFailure: ");
//            }
//        });
        return null;
    }


}
