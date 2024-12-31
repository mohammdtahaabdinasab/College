package com.mtab.finaly;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FinalyScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finaly_screen);

        // Get views
        TextView resultTitle = findViewById(R.id.resultTitle);
        TextView scoreText = findViewById(R.id.scoreText);
        TextView timeText = findViewById(R.id.timeText);
        TextView messageText = findViewById(R.id.messageText);
        Button btnMainMenu = findViewById(R.id.btnMainMenu);

        // Get data from intent
        int score = getIntent().getIntExtra("Score", 0);
        boolean isTimeUp = getIntent().getBooleanExtra("TimeUp", true);
        boolean hasWon = getIntent().getBooleanExtra("HasWon", false);

        // Set score text
        scoreText.setText("Score: " + score + "/10");

        // Set result based on win/lose condition
        if (hasWon) {
            resultTitle.setText("You Win!");
            resultTitle.setTextColor(Color.parseColor("#4CAF50")); // Green
            
            if (isTimeUp) {
                messageText.setText("Great job! You got enough correct answers before time ran out!");
            } else {
                messageText.setText("Excellent! You've successfully completed the test!");
            }
        } else {
            resultTitle.setText("You Lose!");
            resultTitle.setTextColor(Color.parseColor("#F44336")); // Red
            
            if (isTimeUp) {
                messageText.setText("Time's up! You need at least 6 correct answers to pass.");
            } else {
                messageText.setText("You need at least 6 correct answers to pass. Try again!");
            }
        }

        // Set time status
        if (isTimeUp) {
            timeText.setText("Time's Up!");
            timeText.setTextColor(Color.parseColor("#F44336")); // Red
        } else {
            timeText.setText("Completed in Time!");
            timeText.setTextColor(Color.parseColor("#4CAF50")); // Green
        }

        // Set button click listener
        btnMainMenu.setOnClickListener(v -> {
            Intent intent = new Intent(FinalyScreen.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}