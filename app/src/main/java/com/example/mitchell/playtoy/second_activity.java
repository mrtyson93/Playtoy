package com.example.mitchell.playtoy;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;


public class second_activity extends ActionBarActivity {

    public void setChar(Button modifying, int count){
        if(count%2 == 0 ){
            modifying.setTextColor(Color.parseColor("#D51405"));
            modifying.setText("X");
        }
        else{
            modifying.setTextColor(Color.parseColor("#ffffff"));
            modifying.setText("O");
        }
    }
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        final Button topLeft = (Button) findViewById(R.id.TopLeft);
        final Button topMiddle = (Button) findViewById(R.id.TopMiddle);
        final Button topRight = (Button) findViewById(R.id.TopRight);
        final Button centerLeft = (Button) findViewById(R.id.CenterLeft);
        final Button centerMiddle = (Button) findViewById(R.id.CenterMiddle);
        final Button centerRight = (Button) findViewById(R.id.CenterRight);
        final Button bottomeLeft = (Button) findViewById(R.id.BottomLeft);
        final Button bottomMiddle = (Button) findViewById(R.id.BottomMiddle);
        final Button bottomRight = (Button) findViewById(R.id.BottomRight);

        topLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChar(topLeft, count);
                count++;
            }
        });

        topMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChar(topMiddle, count);
                count++;

            }
        });

        topRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChar(topRight, count);
                count++;

            }
        });

        centerLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChar(centerLeft, count);
                count++;

            }
        });

        centerMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChar(centerMiddle, count);
                count++;

            }
        });

        centerRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChar(centerRight, count);
                count++;

            }
        });

        bottomeLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChar(bottomeLeft, count);
                count++;

            }
        });

        bottomMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChar(bottomMiddle, count);
                count++;

            }
        });

        bottomRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setChar(bottomRight, count);
                count++;

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second_activity, menu);
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
