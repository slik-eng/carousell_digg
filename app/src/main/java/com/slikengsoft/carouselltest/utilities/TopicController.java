package com.slikengsoft.carouselltest.utilities;

import android.content.Context;
import android.text.TextUtils;

import com.slikengsoft.carouselltest.model.Topic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Here's the main functions applied on the topic model like insert/update/upvote/downvote
 */
public class TopicController {

    private ArrayList<Topic> mTopicsList;
    private static TopicController mTopicController;
    private Context mContext;

    public static TopicController getInstance(Context context) {
        if (mTopicController == null)
            mTopicController = new TopicController(context);
        return mTopicController;
    }

    private TopicController(Context context) {
        mTopicsList = new ArrayList<>();
        mContext = context;
        initDataSet();
        orderTopicList();
    }

    public ArrayList<Topic> getTopicsList() {
        return mTopicsList;
    }


    //This function can create random 20 topic with random upvote, downvote and title
    private void initDataSet() {
        for (int i = 0; i < 20; i++) {
            Topic topic = new Topic(AppUtilities.randomNum(100), AppUtilities.randomNum(12), AppUtilities.generate(AppUtilities.load(mContext)));
            mTopicsList.add(topic);
        }
    }


    public boolean addNewTopic(String title) {
        if (TextUtils.isEmpty(title))
            return false;
        mTopicsList.add(new Topic(0, 0, title));
        return true;
    }

    public Topic getTopic(int position){
        if(position >= mTopicsList.size())
            throw new ArrayIndexOutOfBoundsException();
        return mTopicsList.get(position);
    }

    public void updateTopicDownVote(int position){
        mTopicsList.get(position).setDownVote(mTopicsList.get(position).getDownVote()+1);
    }

    public void updateTopicUpVote(int position){
        mTopicsList.get(position).setUpVote(mTopicsList.get(position).getUpVote()+1);
        orderTopicList();
    }

    //To order list of topic descending according to upVote
    private void orderTopicList() {
        Collections.sort(mTopicsList, (p1, p2) -> p2.getUpVote() - p1.getUpVote());
    }


}
