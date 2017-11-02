package example.pullrequest.com.services.rest;

import java.util.List;

import example.pullrequest.com.api.PullRequestResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by phundal on 11/2/17.
 */

public interface IRestClient {
    @GET("/repos/{owner}/{repo}/pulls")
    Observable<List<PullRequestResponse>> getPullRequests(@Path("owner") String owner, @Path("repo") String repo);
}
