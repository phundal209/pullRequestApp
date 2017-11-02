package example.pullrequest.com.pullrequestapp.ui.main;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import example.pullrequest.com.api.PullRequestResponse;
import example.pullrequest.com.pullrequestapp.framework.Presenter;
import example.pullrequest.com.pullrequestapp.ui.main.adapter.PullRequestRecycler;
import example.pullrequest.com.services.observers.IApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by phundal on 11/2/17.
 */

public class MainPresenter extends Presenter<MainView, Object> implements IMainPresenter {
    private IApiService apiService;
    private String defaultRepoUrl = "gambol99/keycloak-proxy";
    private String githubPrefixUrl = "www.github.com/";
    private String OPEN_PR = "open";
    private static final String TAG = MainPresenter.class.getSimpleName();

    PullRequestRecycler adapter;
    List<PullRequestResponse> listOfOpenPrs;
    LinearLayoutManager linearLayoutManager;

    public MainPresenter(Context context, MainView view, IApiService apiService) {
        super(context, view, false);
        this.apiService = apiService;
        listOfOpenPrs = new ArrayList<>();
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void bindControls() {
        view.publicRepoUrl.setText(defaultRepoUrl);
        int seperatorIndex = defaultRepoUrl.indexOf("/");
        final String owner = defaultRepoUrl.substring(0, seperatorIndex);
        final String repo = defaultRepoUrl.substring(seperatorIndex + 1, defaultRepoUrl.length());

        view.getResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiService.getPullRequestsAsync(owner, repo)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new Consumer<List<PullRequestResponse>>() {
                            @Override
                            public void accept(List<PullRequestResponse> pullRequestResponses) throws Exception {
                                if(pullRequestResponses != null) {
                                    createListOfOpenPrs(pullRequestResponses);
                                    adapter = new PullRequestRecycler(context, listOfOpenPrs, MainPresenter.this);
                                    linearLayoutManager = new LinearLayoutManager(context);
                                    view.recycler.setLayoutManager(linearLayoutManager);
                                    view.recycler.setAdapter(adapter);
                                }
                            }
                        });
            }
        });

    }

    private void createListOfOpenPrs(List<PullRequestResponse> pullRequestResponses) {
        for(PullRequestResponse pullRequestResponse : pullRequestResponses) {
            if(pullRequestResponse.state.equals(OPEN_PR)) {
                listOfOpenPrs.add(pullRequestResponse);
            }
        }
    }

    @Override
    public void hide() {

    }

    @Override
    public void show() {

    }
}
