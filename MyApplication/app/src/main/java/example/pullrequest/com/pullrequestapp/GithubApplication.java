package example.pullrequest.com.pullrequestapp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import javax.inject.Inject;

import example.pullrequest.com.pullrequestapp.injection.AppModule;
import example.pullrequest.com.pullrequestapp.injection.ApplicationComponent;
import example.pullrequest.com.pullrequestapp.injection.DaggerApplicationComponent;

/**
 * Created by phundal on 11/2/17.
 */

public class GithubApplication extends MultiDexApplication {
    private ApplicationComponent applicationComponent;
    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
