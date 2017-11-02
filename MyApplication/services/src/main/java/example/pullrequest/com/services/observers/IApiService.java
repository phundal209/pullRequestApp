package example.pullrequest.com.services.observers;

import java.util.List;

import example.pullrequest.com.api.PullRequestResponse;
import io.reactivex.Observable;

/**
 * Created by phundal on 11/2/17.
 */

public interface IApiService {
    Observable<List<PullRequestResponse>> getPullRequestsAsync(String owner, String repo);
}
