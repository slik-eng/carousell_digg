package com.slikengsoft.carouselltest.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.slikengsoft.carouselltest.R;
import com.slikengsoft.carouselltest.model.Topic;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Here's the topic adapter to insert the value of topic into the ui row
 */
public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {

    ArrayList<Topic> mArrayListTopic;
    Context mContext;
    OnVoteClickListener onVoteClickListener;

    public TopicAdapter(ArrayList<Topic> arrayListTopic, Context context, OnVoteClickListener onVoteClickListener) {
        this.mArrayListTopic = arrayListTopic;
        this.mContext = context;
        this.onVoteClickListener = onVoteClickListener;
    }

    @NonNull
    @Override
    public TopicAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TopicAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapet_topic, parent, false), onVoteClickListener);
    }

    @Override
    public void onBindViewHolder(TopicAdapter.ViewHolder holder, int position) {
        holder.bind(position, mArrayListTopic.get(position));
    }

    @Override
    public int getItemCount() {
        return (mArrayListTopic != null && mArrayListTopic.size() > 0) ? mArrayListTopic.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.text_view_down_vote)
        public TextView mTextViewDownVote;
        @BindView(R.id.text_view_up_vote)
        public TextView mTextViewUpVote;
        @BindView(R.id.text_view_topic_title)
        public TextView mTextViewTitle;

        private int mPosition;
        private Topic mTopic;
        private OnVoteClickListener mOnVoteClickListener;

        public ViewHolder(View itemView, OnVoteClickListener onVoteClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mOnVoteClickListener = onVoteClickListener;
            mTextViewUpVote.setOnClickListener(this);
            mTextViewDownVote.setOnClickListener(this);
        }

        public void bind(int position, Topic topic) {
            mPosition = position;
            mTextViewDownVote.setText(mContext.getResources().getString(R.string.down_vote) + " " + topic.getDownVote());
            mTextViewUpVote.setText(mContext.getResources().getString(R.string.down_vote) + " " + topic.getUpVote());
            mTextViewTitle.setText(topic.getTitle());
        }

        @Override
        public void onClick(View v) {
            if (mOnVoteClickListener != null) {
                mOnVoteClickListener.onClick(v, mPosition, mTopic);
            }
        }
    }

    public interface OnVoteClickListener {
        void onClick(View view, int position, Topic topic);
    }
}
