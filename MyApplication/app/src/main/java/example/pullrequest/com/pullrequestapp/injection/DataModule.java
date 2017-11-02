package example.pullrequest.com.pullrequestapp.injection;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import example.pullrequest.com.pullrequestapp.injection.annotation.PerActivity;
import example.pullrequest.com.services.observers.ApiService;
import example.pullrequest.com.services.observers.IApiService;
import example.pullrequest.com.services.retrofit.IRetrofitProvider;

/**
 * Created by phundal on 9/6/17.
 */
@Module
public class DataModule {
    private final Activity activity;

    public DataModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    IApiService providesApiService(IRetrofitProvider retrofitProvider) {
        return new ApiService(retrofitProvider);
    }

}
