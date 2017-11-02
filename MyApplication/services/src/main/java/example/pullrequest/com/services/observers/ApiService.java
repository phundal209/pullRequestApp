package example.pullrequest.com.services.observers;

import example.pullrequest.com.services.rest.IRestClient;
import example.pullrequest.com.services.retrofit.IRetrofitProvider;

/**
 * Created by phundal on 11/2/17.
 */

public class ApiService implements IApiService {
    private IRestClient restClient;

    public ApiService(IRetrofitProvider retrofitProvider) {
        this.restClient = retrofitProvider.getRetrofit().create(IRestClient.class);
    }

}
