package com.android.rexben.rexy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Quiz3 extends AppCompatActivity {
    // Declaring fields
    private int score = 0;
    private int points = 0;
    private int newScore;
    private int newPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);


    }
    /*
    * If the user enter True as the answer, 5 is added to his
    * scores, and a toast message will show telling him that
    * he just entered the current answer
    *
     */
    public void ClickMe(View view) {
        Intent intent = getIntent();
        final int mScore = intent.getIntExtra("score", 0); // Get score from the preious activity
        final int mPoints = intent.getIntExtra("points", 0); // Get score from the preious activity

        String answer = ((EditText) findViewById(R.id.editText)).getText().toString();
        String correctAnswer = getString(R.string.answer_3);

        if (answer.equalsIgnoreCase(correctAnswer)) {
            score += 1;
            newScore = mScore + score; // Update score

            points += 5;

            newPoints = mPoints + points; // Update score


            Toast toast = Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT);
            toast.show();

            Intent intenty = new Intent(getApplicationContext(), Quiz4.class);
            intenty.putExtra("score", newScore); //Send the updated score to the next activity
            intenty.putExtra("points", newPoints); //Send the updated points to the next activity

            startActivity(intenty);
        } else {          // Toast message display "wrong" and the right answer and takes the user to the next quesstion

            newScore = mScore + score;
            newPoints = mPoints + points;

            Toast toast = Toast.makeText(getApplicationContext(), "Wrong." + "\n Answer is: "  +correctAnswer, Toast.LENGTH_SHORT);
            toast.show();

            Intent intentyx = new Intent(getApplicationContext(), Quiz4.class);
            intentyx.putExtra("score", newScore);
            intentyx.putExtra("points", newPoints);

            startActivity(intentyx);
        }
    }
}