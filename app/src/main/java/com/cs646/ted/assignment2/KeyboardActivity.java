package com.cs646.ted.assignment2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


public class KeyboardActivity extends ActionBarActivity {

    public static final String EXTRA_MAIN_EDITTEXT = "mainexittext";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);

        Bundle initTopEditText = getIntent().getExtras();
        EditText topEditText = (EditText) findViewById(R.id.keyboard_top_edit_text);
        topEditText.setText(initTopEditText.getString(EXTRA_MAIN_EDITTEXT));

        final Button hideButton = (Button) findViewById(R.id.keyboard_button_hide);
        hideButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText tmpEditText = (EditText)findViewById(R.id.keyboard_top_edit_text);
                InputMethodManager manager;
                manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                manager.hideSoftInputFromWindow(tmpEditText.getWindowToken(),0);
            }
        });

        final Button backButton = (Button) findViewById(R.id.keyboard_button_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_keyboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
