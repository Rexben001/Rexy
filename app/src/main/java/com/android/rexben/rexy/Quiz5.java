package com.android.rexben.rexy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Quiz5 extends AppCompatActivity {
    // Declaring fields
    private int score = 0;
    private int points = 0;
    private int newScore;
    private int newPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);
    }
     /*
    * If the user type True as the answer and click on submit, 5 is added to his
    * scores, and a toast message will show telling him that
    * he just entered the current answer and automatically jumps
    * to the next question
    *
     */


    public void ClickMe(View view) {
        Intent intent = getIntent();
        final int mScore = intent.getIntExtra("score", 0);//score gotten from the previous activity
        final int mPoints = intent.getIntExtra("points", 0);//score gotten from the previous activity

        String answer = ((EditText) findViewById(R.id.editText2)).getText().toString();
        String correctAnswer = getString(R.string.answer_5); //Correct answer

        if (answer.equalsIgnoreCase(correctAnswer)) {
            score += 1;
            newScore = mScore + score; // Updating the scores

            points += 5;
            newPoints = mPoints + points; //Updating the points

            Toast toast = Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT);
            toast.show();

            Intent intenty = new Intent(getApplicationContext(), TotalScore.class);
            intenty.putExtra("score", newScore); // Sends the updated score to the next activity
            intenty.putExtra("points", newPoints); // Sends the updated points to the next activity

            startActivity(intenty);

        } else { // Toast message display "wrong" and the right answer and takes the user to the next quesstion
            Toast toast = Toast.makeText(getApplicationContext(), "Wrong." + "\n Answer is: " + correctAnswer, Toast.LENGTH_SHORT);
            toast.show();
            newScore = mScore + score;
            newPoints = mPoints + points;

            Intent intentyx = new Intent(getApplicationContext(), TotalScore.class);
            intentyx.putExtra("score", newScore);
            intentyx.putExtra("points", newPoints);

            startActivity(intentyx);
        }
    }
}
