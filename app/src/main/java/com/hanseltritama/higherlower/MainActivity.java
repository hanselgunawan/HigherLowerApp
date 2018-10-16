package com.hanseltritama.higherlower;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.Math;
import java.lang.Runnable;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public void onClickSubmit(View view) {

        final EditText numberEditText = findViewById(R.id.numberEditText);
        final Button submitBtn = findViewById(R.id.submitBtn);
        final TextView alertTextView = findViewById(R.id.alertTextView);
        //By default, the Math.random() method returns a random number of the type double whenever it is called.
        //Math.Random => [0.00 -> 0.99]
        //(Math.random()*((max-min)+1))+min;
        double randomNumber = Math.floor(Math.random()*((20-1)+1)+1);
        double guessedNumber = Double.parseDouble(numberEditText.getText().toString());

        alertTextView.setVisibility(View.VISIBLE);
        submitBtn.setEnabled(false);

        if(randomNumber == guessedNumber) alertTextView.setText(R.string.correct_message);
        else alertTextView.setText(R.string.incorrect_message);

        Log.i("Random Number: ", String.valueOf(randomNumber));
        Log.i("Guessed Number: ", String.valueOf(guessedNumber));

        Handler timeOut = new Handler();
        timeOut.postDelayed(new Runnable() {
            @Override
            public void run() {
                alertTextView.setVisibility(View.GONE);
                submitBtn.setEnabled(true);
                numberEditText.setText("");
            }
        }, 1500);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
