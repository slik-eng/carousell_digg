package com.slikengsoft.carouselltest.view;

import android.app.Activity;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.slikengsoft.carouselltest.R;
import com.slikengsoft.carouselltest.TestUtlis;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;



import static org.junit.Assert.*;

public class AddTopicActivityTest {

    @Rule
    public ActivityTestRule<AddTopicActivity> mRule = new ActivityTestRule<AddTopicActivity>(AddTopicActivity.class);

    @Test
    public void testAddEmptyTopic(){
        Espresso.onView(ViewMatchers.withId(R.id.btn_add)).perform(ViewActions.click());
        Activity activity = TestUtlis.getActivityInstance();
        assertThat(activity, Matchers.instanceOf(AddTopicActivity.class));
    }

    @Test
    public void testAddTopicValue(){
        Espresso.onView(ViewMatchers.withId(R.id.edit_text_topic_title)).perform(ViewActions.typeText("3123123"));
        Espresso.onView(ViewMatchers.withId(R.id.btn_add)).perform(ViewActions.click());
        Activity activity = TestUtlis.getActivityInstance();
        assertThat(activity, Matchers.instanceOf(MainActivity.class));
    }

    @Test
    public void testAddLargeTopic(){
        String test = "";
        for (int i =0 ;i<300; i++){
            test = test+i;
        }
        Espresso.onView(ViewMatchers.withId(R.id.edit_text_topic_title)).perform(ViewActions.typeText(test));
        Espresso.onView(ViewMatchers.withId(R.id.edit_text_topic_title)).check(ViewAssertions.matches(CoreMatchers.not(ViewMatchers.withText(test))));
    }
}