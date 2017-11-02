package example.pullrequest.com.pullrequestapp.injection;


import dagger.Component;
import example.pullrequest.com.pullrequestapp.ui.MainActivity;
import example.pullrequest.com.pullrequestapp.injection.annotation.PerActivity;

/**
 * Created by phundal on 9/6/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, DataModule.class})
public interface MainActivityComponent extends AbstractActivityComponent {
    void inject(MainActivity mainActivity);
}
