package example.pullrequest.com.pullrequestapp.injection;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.pullrequest.com.services.retrofit.IRetrofitProvider;
import example.pullrequest.com.services.retrofit.RetrofitProvider;

/**
 * Created by phundal on 9/6/17.
 */

@Module
public class AppModule {
    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }


    @Provides @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    IRetrofitProvider providesRetrofitProvider() {
        return new RetrofitProvider();
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

}
