package com.slikengsoft.carouselltest.view;

import android.app.Activity;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.slikengsoft.carouselltest.R;
import com.slikengsoft.carouselltest.RecyclerViewItemCountAssertion;
import com.slikengsoft.carouselltest.TestUtlis;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testFAB(){
        Espresso.onView(ViewMatchers.withId(R.id.fab_add)).perform(ViewActions.click());
        Activity activity = TestUtlis.getActivityInstance();
        assertThat(activity, Matchers.instanceOf(AddTopicActivity.class));
    }

    @Test
    public void testInitValues(){
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view_topic)).check(new RecyclerViewItemCountAssertion(20));

    }

}