package com.slikengsoft.carouselltest.model;

/**
 * This's like a model class for our topic and for test purpose it contains only title and can be more complicated like topicDesc, image and etc
 */
public class Topic {
    private int mUpVote;
    private int mDownVote;
    private String mTitle;

    public Topic(int mUpVote, int mDownVote, String mTitle) {
        this.mUpVote = mUpVote;
        this.mDownVote = mDownVote;
        this.mTitle = mTitle;
    }

    public int getUpVote() {
        return mUpVote;
    }

    public void setUpVote(int mUpVote) {
        this.mUpVote = mUpVote;
    }

    public int getDownVote() {
        return mDownVote;
    }

    public void setDownVote(int mDownVote) {
        this.mDownVote = mDownVote;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
