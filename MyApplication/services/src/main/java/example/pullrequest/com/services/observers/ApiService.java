package example.pullrequest.com.services.observers;


import java.util.List;

import example.pullrequest.com.api.PullRequestResponse;
import example.pullrequest.com.services.rest.IRestClient;
import example.pullrequest.com.services.retrofit.IRetrofitProvider;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by phundal on 11/2/17.
 */

public class ApiService implements IApiService {
    private IRestClient restClient;

    public ApiService(IRetrofitProvider retrofitProvider) {
        this.restClient = retrofitProvider.getRetrofit().create(IRestClient.class);
    }

    @Override
    public Observable<List<PullRequestResponse>> getPullRequestsAsync(String owner, String repo) {
        return restClient.getPullRequests(owner, repo).map(new Function<List<PullRequestResponse>, List<PullRequestResponse>>() {
            @Override
            public List<PullRequestResponse> apply(List<PullRequestResponse> list) throws Exception {
                if(list != null && list.size() > 0) {
                    return list;
                }
                return null;
            }
        });
    }

}
