package example.pullrequest.com.pullrequestapp.ui.main;

import android.widget.EditText;

import butterknife.Bind;
import example.pullrequest.com.pullrequestapp.R;
import example.pullrequest.com.pullrequestapp.framework.ViewScreen;

/**
 * Created by phundal on 11/2/17.
 */

public class MainView extends ViewScreen {

    @Bind(R.id.publicRepoUrl)
    public EditText publicRepoUrl;
}
