package com.example.mitchell.playtoy;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class rateMonitor extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_monitor);

        //hides action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //variables needed
            //[0] is the rate, [1-3] are the times the button has been pressed, [4], is the press counter
            //[5] is for the 0.5
        final long[] rate = {0,0,0,0,0,0};
        Button rateBtn = (Button) findViewById(R.id.timeBtn);
        TextView rateText = (TextView) findViewById(R.id.rateText);


        //initiaize text
        rateText.setText("" + rate[0]);

        rateBtn.setOnClickListener(v -> {


            //gets the new time
            rate[3] = rate[2];
            rate[2] = rate[1];
            rate[1] = System.currentTimeMillis();

            rate[4]++;  //increment counter so we get rate after 3 button presses

            //only calculate rate if more than three presses
            if(2 < rate[4]){
                rate[0] = (rate[1] - rate[3]);
                rate[5] = rate[0] % 33; //this is for remainder, determines half beat
                rate[0] /= 33.3333;
                Math.floor(rate[0]);
                rate[0] += 0.5;

                //keeps the floor
                if(rate[5] < 8){
                    rateText.setText("" + rate[0]);
                }

                //adds the 0.5
                else if(rate[5] < 25){
                    rateText.setText("" + rate[0] + ".5");
                }

                //rounds up to the next beat
                else{
                    rate[0]++;
                    rateText.setText("" + rate[0]);
                }
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rate_monitor, menu);
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
