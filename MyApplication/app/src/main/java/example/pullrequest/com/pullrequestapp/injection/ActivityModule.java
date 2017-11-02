package example.pullrequest.com.pullrequestapp.injection;

import android.app.Activity;


import dagger.Module;
import dagger.Provides;
import example.pullrequest.com.pullrequestapp.injection.annotation.PerActivity;
import example.pullrequest.com.pullrequestapp.ui.main.IMainPresenter;
import example.pullrequest.com.pullrequestapp.ui.main.MainPresenter;
import example.pullrequest.com.pullrequestapp.ui.main.MainView;
import example.pullrequest.com.services.observers.IApiService;

/**
 * Created by phundal on 9/6/17.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    Activity activity() {
        return activity;
    }

    @Provides
    @PerActivity
    IMainPresenter mainPresenter(IApiService apiService) {
        return new MainPresenter(activity, new MainView(), apiService);
    }
}
