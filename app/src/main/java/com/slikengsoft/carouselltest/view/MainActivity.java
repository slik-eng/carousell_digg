package com.slikengsoft.carouselltest.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.slikengsoft.carouselltest.R;
import com.slikengsoft.carouselltest.adapters.TopicAdapter;
import com.slikengsoft.carouselltest.model.Topic;
import com.slikengsoft.carouselltest.utilities.TopicController;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * This's the main ui witch has list of topics
 */
public class MainActivity extends BaseActivity implements TopicAdapter.OnVoteClickListener{

    @BindView(R.id.recycler_view_topic)
    RecyclerView mRecyclerViewTopic;

    TopicAdapter mTopicAdapter;
    TopicController mTopicController;
    private static final int REQUEST_CODE = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        init();
        initViews();
    }

    private void initViews(){
        mRecyclerViewTopic.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewTopic.setAdapter(mTopicAdapter);
    }

    private void init(){
        mTopicController = TopicController.getInstance(this);
        mTopicAdapter = new TopicAdapter(mTopicController.getTopicsList(), this, this);
    }

    @Override
    public void onClick(View view, int position, Topic topic) {
        if(view.getId()==R.id.text_view_up_vote){//This click here for upVote to increase and update item list if needed
            mTopicController.updateTopicUpVote(position);
            mTopicAdapter.notifyDataSetChanged();
        }else if(view.getId() == R.id.text_view_down_vote){//This click here for downVote
            mTopicController.updateTopicDownVote(position);
        }
    }

    //This for add new topic
    @OnClick(R.id.fab_add)
    public void addNewTopic(){
        startActivityForResult(new Intent(this, AddTopicActivity.class), REQUEST_CODE);
    }

    //To insert the new topic into the list
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == REQUEST_CODE){
            mTopicController.addNewTopic(data.getStringExtra("title"));
            mTopicAdapter.notifyDataSetChanged();
        }
    }
}
