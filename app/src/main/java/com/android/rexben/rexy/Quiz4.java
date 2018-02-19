package com.android.rexben.rexy;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz4 extends AppCompatActivity {
    private int score = 0;
    private int points = 0;
    private int newScore;
    private int newPoints;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
        // Casting  views by ResourceID
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGrp);

        Intent intent = getIntent();
        final int mScore = intent.getIntExtra("score", 0); //Getting the score from the previous activity
        final int mPoints = intent.getIntExtra("points", 0); //Getting the score from the previous activity

  /*
        *   If radioButton6 is checked, the toast message shows Corroect
        *   5 is added to the score and the user is taken to the
        *   next question
         */

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                String answer = getString(R.string.answer_4); //answer
                switch (i) {
                    case R.id.radioButton4:
                        // Toast message display "wrong" and the right answer and takes the user to the next quesstion
                        Toast toast = Toast.makeText(getApplicationContext(), "Wrong " + "\n Answer is: "  +answer, Toast.LENGTH_SHORT);
                        toast.show();
                        newScore = mScore + score; //Update score
                        newPoints = mPoints + points; //Update points


                        Intent intent0 = new Intent(getApplicationContext(), Quiz5.class);
                        intent0.putExtra("score", newScore); //Send the updated score to the next activity
                        intent0.putExtra("points", newPoints); //Send the updated points to the next activity

                        startActivity(intent0);
                        break;

                    case R.id.radioButton5:
                        // Toast message display "wrong" and the right answer and takes the user to the next quesstion
                        Toast toast1 = Toast.makeText(getApplicationContext(), "Wrong." + "\n Answer is: " + answer, Toast.LENGTH_SHORT);
                        toast1.show();
                        newScore = mScore + score;
                        newPoints = mPoints + points;



                        Intent intent1 = new Intent(getApplicationContext(), Quiz5.class);
                        intent1.putExtra("score", newScore);
                        intent1.putExtra("points", newPoints);

                        startActivity(intent1);
                        break;

                    case R.id.radioButton6:
                        //Toast message displays "Correct"
                        //Update score with 1
                        //Update points with 5
                        score += 1;
                        newScore = mScore + score;

                        points += 5;
                        newPoints = mPoints + points;
                        Toast toast2 = Toast.makeText(getApplicationContext(), "Correct ", Toast.LENGTH_SHORT);
                        toast2.show();

                        Intent intent2 = new Intent(getApplicationContext(), Quiz5.class);
                        //send the new score and points to the next activity
                        intent2.putExtra("score", newScore);
                        intent2.putExtra("points", newPoints);

                        startActivity(intent2);
                        break;
                }
            }
        });
    }
}

