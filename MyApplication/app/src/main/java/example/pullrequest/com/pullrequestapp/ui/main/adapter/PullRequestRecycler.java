package example.pullrequest.com.pullrequestapp.ui.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.pullrequest.com.api.PullRequestResponse;
import example.pullrequest.com.pullrequestapp.R;
import example.pullrequest.com.pullrequestapp.ui.diff_view.DiffActivity;
import example.pullrequest.com.pullrequestapp.ui.main.FileUtilities;
import example.pullrequest.com.pullrequestapp.ui.main.IMainPresenter;

/**
 * Created by phundal on 11/2/17.
 */

public class PullRequestRecycler extends RecyclerView.Adapter<PullRequestRecycler.ViewHolder> {
    private Context context;
    private List<PullRequestResponse> listOfpullRequests;
    private IMainPresenter presenter;

    public PullRequestRecycler(Context context, List<PullRequestResponse> listOfpullRequests, IMainPresenter presenter) {
        this.context = context;
        this.listOfpullRequests = listOfpullRequests;
        this.presenter = presenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pull_request_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PullRequestResponse prObject = listOfpullRequests.get(position);
        holder.nameOfPr.setText(prObject.title);
        String infoLabel = context.getResources().getString(R.string.info_label, prObject.number, prObject.created_at, prObject.user.login);
        holder.prInfoLabel.setText(infoLabel);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DiffActivity.class);
                intent.putExtra(DiffActivity.diffUrlKey, prObject.diff_url);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listOfpullRequests == null) { return 0; }
        return listOfpullRequests.size();
    }

    public void clear() {
        listOfpullRequests.clear();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.nameOfPr)
        public TextView nameOfPr;
        @Bind(R.id.prInfoLabel)
        public TextView prInfoLabel;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
