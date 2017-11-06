package example.pullrequest.com.pullrequestapp.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import example.pullrequest.com.pullrequestapp.GithubApplication;
import example.pullrequest.com.pullrequestapp.R;
import example.pullrequest.com.pullrequestapp.injection.ActivityModule;
import example.pullrequest.com.pullrequestapp.injection.DaggerMainActivityComponent;
import example.pullrequest.com.pullrequestapp.injection.DataModule;
import example.pullrequest.com.pullrequestapp.injection.MainActivityComponent;
import example.pullrequest.com.pullrequestapp.ui.main.IMainPresenter;

public class MainActivity extends AppCompatActivity {
    private MainActivityComponent component;
    @Inject
    IMainPresenter mainPresenter;

    MainActivityComponent component() {
        if (component == null) {
            component = DaggerMainActivityComponent.builder()
                    .applicationComponent((getGithubApplication()).getComponent())
                    .activityModule(new ActivityModule(this))
                    .dataModule(new DataModule(this))
                    .build();
        }
        return component;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        component().inject(this);
        mainPresenter
                .getView()
                .withRootView(this.findViewById(android.R.id.content).getRootView());
        mainPresenter.bindControls();

    }

    private GithubApplication getGithubApplication() {
        return (GithubApplication) getApplication();
    }
}
