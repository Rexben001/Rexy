package com.android.rexben.rexy;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.android.rexben.rexy.R.id.radioButton;

public class Quiz2 extends AppCompatActivity {
    private int score = 0;
    private int points = 0;
    private int newScore;
    private int newPoints;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        // Casting views by Resource ID
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        // Getting scores from the previous activity
        Intent intent = getIntent();
        final int mScore = intent.getIntExtra("score", 0);
        final int mPoints = intent.getIntExtra("points", 0);


        /*
        *   If radioButton is checked, the toast message shows Corroect
        *   5 is added to the score and the user is taken to the
        *   next question
         */
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            String answer = getString(R.string.answer_2);

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.radioButton:
                        score += 1; //
                        newScore = mScore + score; // Update the score

                        points += 5;
                        newPoints = mPoints + points;
                        Toast toast = Toast.makeText(getApplicationContext(), "Correct ", Toast.LENGTH_SHORT);
                        toast.show();

                        Intent intent = new Intent(getApplicationContext(), Quiz3.class);
                        intent.putExtra("score", newScore); // Send the updated score to the next activity
                        intent.putExtra("points", newPoints); // Send the updated score to the next activity

                        startActivity(intent);
                        break;
                    case R.id.radioButton2:
                        Toast toast1 = Toast.makeText(getApplicationContext(), "Wrong  " + "\n Answer is: " + answer, Toast.LENGTH_SHORT);
                        toast1.show();
                        newScore = mScore + score;
                        newPoints = mPoints + points;


                        Intent intent1 = new Intent(getApplicationContext(), Quiz3.class);
                        intent1.putExtra("score", newScore);
                        intent1.putExtra("points", newPoints); // Send the updated score to the next activity

                        startActivity(intent1);
                        break;
                    case R.id.radioButton3:
                        Toast toast2 = Toast.makeText(getApplicationContext(), "Wrong " + "\n Answer is: " + answer, Toast.LENGTH_SHORT);
                        toast2.show();
                        newScore = mScore + score;
                        newPoints = mPoints + points;


                        Intent intent2 = new Intent(getApplicationContext(), Quiz3.class);
                        intent2.putExtra("score", newScore);
                        intent2.putExtra("points", newPoints); // Send the updated score to the next activity

                        startActivity(intent2);
                        break;
                }
            }
        });

    }
}

