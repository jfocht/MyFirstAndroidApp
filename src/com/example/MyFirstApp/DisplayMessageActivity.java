package com.example.MyFirstApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.content.res.TypedArray;

public class DisplayMessageActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(buildTextView(getMainActivityExtraMessage()));
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

    private TextView buildTextView(String message) {
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        textView.setPaddingRelative(0, getActionBarSize(), 0, 0);

        return textView;
    }

    private int getActionBarSize() {
        int[] attrs = new int[] { android.R.attr.actionBarSize };
        TypedArray styledAttributes = getTheme().obtainStyledAttributes(attrs);
        int size = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();
        return size;
    }

    private String getMainActivityExtraMessage() {
        return getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
    }

}
