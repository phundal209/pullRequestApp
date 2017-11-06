package example.pullrequest.com.pullrequestapp.ui.diff_view;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import example.pullrequest.com.pullrequestapp.R;

/**
 * Created by phundal on 11/3/17.
 */

public class DiffActivity extends Activity {
    private WebView webView;
    public static final String diffUrlKey = "diffUrl";
    String diffUrl;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        webView = findViewById(R.id.diffWebview);

        if(getIntent() != null
                && getIntent().getExtras() != null
                && getIntent().getExtras().getString(diffUrlKey) != null) {
            diffUrl = getIntent().getExtras().getString(diffUrlKey);
            webView.loadUrl(diffUrl);
        }

    }

}
