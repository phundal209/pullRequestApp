package example.pullrequest.com.pullrequestapp.injection;
import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import example.pullrequest.com.pullrequestapp.GithubApplication;
import example.pullrequest.com.services.retrofit.IRetrofitProvider;

@Singleton
@Component(modules = {AppModule.class})
public interface ApplicationComponent {
    void inject(GithubApplication application);
    // Exported for child-components.
    Application application();
    IRetrofitProvider retrofitProvider();

}