package com.example.MyFirstApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class DisplayMessageActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(buildTextView(getMainActivityExtraMessage()));
    }

    private TextView buildTextView(String message) {
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        return textView;
    }

    private String getMainActivityExtraMessage() {
        return getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
