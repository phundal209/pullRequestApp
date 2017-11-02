package example.pullrequest.com.api;

/**
 * Created by phundal on 11/2/17.
 */

public class PullRequestResponse {

    @com.google.gson.annotations.SerializedName("url")
    public String url;
    @com.google.gson.annotations.SerializedName("id")
    public int id;
    @com.google.gson.annotations.SerializedName("html_url")
    public String html_url;
    @com.google.gson.annotations.SerializedName("diff_url")
    public String diff_url;
    @com.google.gson.annotations.SerializedName("patch_url")
    public String patch_url;
    @com.google.gson.annotations.SerializedName("issue_url")
    public String issue_url;
    @com.google.gson.annotations.SerializedName("number")
    public int number;
    @com.google.gson.annotations.SerializedName("state")
    public String state;
    @com.google.gson.annotations.SerializedName("locked")
    public boolean locked;
    @com.google.gson.annotations.SerializedName("title")
    public String title;
    @com.google.gson.annotations.SerializedName("user")
    public User user;
    @com.google.gson.annotations.SerializedName("body")
    public String body;
    @com.google.gson.annotations.SerializedName("created_at")
    public String created_at;
    @com.google.gson.annotations.SerializedName("updated_at")
    public String updated_at;
    @com.google.gson.annotations.SerializedName("closed_at")
    public String closed_at;
    @com.google.gson.annotations.SerializedName("merged_at")
    public String merged_at;
    @com.google.gson.annotations.SerializedName("merge_commit_sha")
    public String merge_commit_sha;
    @com.google.gson.annotations.SerializedName("assignee")
    public Assignee assignee;
    @com.google.gson.annotations.SerializedName("assignees")
    public java.util.List<Assignees> assignees;
    @com.google.gson.annotations.SerializedName("requested_reviewers")
    public java.util.List<Requested_reviewers> requested_reviewers;
    @com.google.gson.annotations.SerializedName("milestone")
    public String milestone;
    @com.google.gson.annotations.SerializedName("commits_url")
    public String commits_url;
    @com.google.gson.annotations.SerializedName("review_comments_url")
    public String review_comments_url;
    @com.google.gson.annotations.SerializedName("review_comment_url")
    public String review_comment_url;
    @com.google.gson.annotations.SerializedName("comments_url")
    public String comments_url;
    @com.google.gson.annotations.SerializedName("statuses_url")
    public String statuses_url;
}
