package com.example.mitchell.playtoy;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Dialog;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.content.Context;



public class MainActivity extends ActionBarActivity {
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //***This does main app shit**//
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //these make the buttons/textView = the ones from activity_main.xml
        Button open_Btn = (Button) findViewById(R.id.contBtn);
        final TextView testing = (TextView) findViewById(R.id.textView1);

        //does the popup to decide if you want to vs Comp or Human
        open_Btn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,decideVersion.class)));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
