package example.pullrequest.com.pullrequestapp.injection;

/**
 * Created by phundal on 9/6/17.
 */

import android.app.Activity;


import dagger.Component;
import example.pullrequest.com.pullrequestapp.injection.annotation.PerActivity;

/**
 * A base component upon which fragment's components may depend.  Activity-level components
 * should extend this component.
 */
@PerActivity // Subtypes of AbstractActivityComponent should be decorated with @PerActivity.
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, DataModule.class})
public interface AbstractActivityComponent {
    Activity activity(); // Expose the activity to sub-graphs.
}