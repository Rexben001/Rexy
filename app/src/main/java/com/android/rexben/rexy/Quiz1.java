package com.android.rexben.rexy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Quiz1 extends AppCompatActivity {
    // Declaring fields
   private CheckBox checkBox, checkBox2, checkBox3;
    private int score = 0;
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        /// Casting views by Resource ID
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
    }
    /*
    *   If the checkbox , checkBox 2 and checkBox 3 are checked and the button is clicked,
      *   then the score is increased by 5, a toast message appears
      *   to shows telling the user correct and taking
    *       the user to the next question.
    *
     */
    public void clickMe(View view) {
        String answer = getString(R.string.answer_1); //Correct answer
        if (checkBox.isChecked() && checkBox2.isChecked() && checkBox3.isChecked()) {
            score += 1; //Add 1 to the score
            points += 5; //Add 5 to the points
            Toast toast = Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT);
            toast.show();

            Intent intent = new Intent(getApplicationContext(), Quiz2.class);
            intent.putExtra("score", score); //Send score to the next activity
            intent.putExtra("points", points); //Send score
            startActivity(intent);


        } else {      // Toast message display "wrong" and the right answer
            // takes the user to the next quesstion
            //sends new score and points to the next activity

            Toast toast = Toast.makeText(getApplicationContext(), "Wrong" + "\n Answer is: "  +answer, Toast.LENGTH_SHORT);
            toast.show();

            Intent intent = new Intent(getApplicationContext(), Quiz2.class);
            intent.putExtra("score", score);
            intent.putExtra("points", points);


            startActivity(intent);


        }
    }
}
