package com.slikengsoft.carouselltest.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.slikengsoft.carouselltest.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * This ui to insert new topic(in our case only title)
 */
public class AddTopicActivity extends BaseActivity {

    @BindView(R.id.edit_text_topic_title)
    EditText mEditTextTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_add_topic);
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.btn_add)
    public void addNewTopic() {
        if (TextUtils.isEmpty(mEditTextTitle.getText())) {
            Toast.makeText(this, "Can't be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("title", mEditTextTitle.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
