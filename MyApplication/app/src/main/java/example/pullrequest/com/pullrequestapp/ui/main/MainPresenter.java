package example.pullrequest.com.pullrequestapp.ui.main;

import android.content.Context;

import java.util.Objects;

import example.pullrequest.com.pullrequestapp.framework.Presenter;
import example.pullrequest.com.services.observers.IApiService;

/**
 * Created by phundal on 11/2/17.
 */

public class MainPresenter extends Presenter<MainView, Object> implements IMainPresenter {
    private IApiService apiService;

    public MainPresenter(Context context, MainView view, IApiService apiService) {
        super(context, view, false);
        this.apiService = apiService;
    }

    @Override
    public void bindControls() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void show() {

    }
}
