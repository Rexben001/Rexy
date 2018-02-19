package com.android.rexben.rexy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TotalScore extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_score);
        //Casting views by ResourcesID
        TextView tv = (TextView) findViewById(R.id.texd);
        TextView tv2 = (TextView) findViewById(R.id.textque2);

        //Getting the totalpoints earned and displaying it
        int points = getIntent().getIntExtra("points", 0);
        tv.setText(points + " ");

        //Getting the totalpoints earned and displaying it
        int score = getIntent().getIntExtra("score", 0);
        tv2.setText(score + " /5");


    }
    //Reset the game
    public void reset (View view){
        Intent intent = new Intent(getApplicationContext(), Quiz1.class);
        startActivity(intent);
    }
}
