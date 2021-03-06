package com.cs646.ted.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DessertActivity extends ActionBarActivity implements DessertFragment.OnSelectionChangeListener{

    public static final String EXTRA_SELECTED_POSITION = "listactivityextra";

    public static int mListItemSelected = -1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert_list);

        final Button back = (Button) findViewById(R.id.dessert_back_button);
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onSelectionChange();
                Intent passBack = getIntent();
                passBack.putExtra(EXTRA_SELECTED_POSITION, mListItemSelected);
                setResult(RESULT_OK, passBack);
                finish();
            }
        });

        mListItemSelected = getIntent().getExtras().getInt(EXTRA_SELECTED_POSITION);
    }

    @Override
    public void onBackPressed() {
        onSelectionChange();
        Intent passBack = getIntent();
        passBack.putExtra(EXTRA_SELECTED_POSITION, mListItemSelected);
        setResult(RESULT_OK, passBack);
        finish();
    }

    @Override
    public void onSelectionChange() {
        DessertFragment dessertFragment = (DessertFragment)getFragmentManager()
                .findFragmentById(R.id.dessert_activity_list_fragment);

        mListItemSelected = dessertFragment.getSelected();
    }

    @Override
    public void onSetSelection(int position) {
        DessertFragment dessertFragment = (DessertFragment) getFragmentManager()
                .findFragmentById(R.id.dessert_activity_list_fragment);

        dessertFragment.select(position);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_desert_list, menu);
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
