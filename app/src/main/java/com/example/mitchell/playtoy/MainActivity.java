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

        //this sets the view to the second activity, should be done with this now
        open_Btn.setOnClickListener(v -> {
            //dialog box
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.dialogbox);

            Button Human = (Button) dialog.findViewById(R.id.vsHuman);
            Button Comp  = (Button) dialog.findViewById(R.id.vsComp);

            // if button is clicked, close the custom dialog
            Human.setOnClickListener(v1 -> {
                Intent i = new Intent(getApplicationContext(), second_activity.class);
                startActivity(i);
            });
            Comp.setOnClickListener(v1 -> {
                Intent i = new Intent(getApplicationContext(), second_activity.class);
                startActivity(i);
            });

            dialog.show();
        });
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
