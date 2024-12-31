package com.mtab.finaly;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionScreen extends AppCompatActivity {
    private String fullName;
    private String email;
    private RadioGroup[] radioGroups = new RadioGroup[10];
    private boolean[] answers = new boolean[10]; // true for correct, false for incorrect
    private boolean[] answered = new boolean[10]; // track if question has been answered
    private int correctAnswers = 0;
    private TextView scoreText;
    private TextView timerText;
    private CountDownTimer timer;
    private static final long TIMER_DURATION = 120000; // 120 seconds
    private boolean isTimeUp = false;

    // Correct answers for each question (true = Yes, false = No)
    private final boolean[] correctAnswerKey = {
        true,   // RAM is temporary memory
        true,   // CPU stands for Central Processing Unit
        false,  // SSD is NOT slower than HDD
        true,   // Windows is an operating system
        false,  // USB is NOT wireless
        true,   // 1 GB = 1024 MB
        false,  // HTML is NOT a programming language
        true,   // Computer can work without dedicated GPU (using integrated)
        true,   // Firefox is a web browser
        true    // IP address is used for internet identification
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_screen);

        // Get user info from intent
        fullName = getIntent().getStringExtra("FullName");
        email = getIntent().getStringExtra("Email");

        scoreText = findViewById(R.id.scoreText);
        timerText = findViewById(R.id.timerText);
        
        // Initialize radio groups
        for (int i = 0; i < 10; i++) {
            final int questionIndex = i;
            radioGroups[i] = findViewById(getResources().getIdentifier("radioGroup" + (i + 1), "id", getPackageName()));
            
            radioGroups[i].setOnCheckedChangeListener((group, checkedId) -> {
                if (!answered[questionIndex]) {
                    // Get the selected answer (true for Yes, false for No)
                    boolean selectedAnswer = checkedId == group.getChildAt(1).getId();
                    
                    // Check if answer is correct
                    answers[questionIndex] = (selectedAnswer == correctAnswerKey[questionIndex]);
                    
                    if (answers[questionIndex]) {
                        correctAnswers++;
                        group.setBackgroundColor(Color.parseColor("#4CAF50")); // Material Green
                    } else {
                        group.setBackgroundColor(Color.parseColor("#F44336")); // Material Red
                    }
                    
                    // Disable the radio group
                    for (int j = 0; j < group.getChildCount(); j++) {
                        group.getChildAt(j).setEnabled(false);
                    }
                    
                    answered[questionIndex] = true;
                    updateScore();
                    checkProgress();
                }
            });
        }

        // Start the timer
        startTimer();
    }

    private void startTimer() {
        timer = new CountDownTimer(TIMER_DURATION, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long seconds = millisUntilFinished / 1000;
                String timeLeft = String.format("Time: %02d:%02d", seconds / 60, seconds % 60);
                timerText.setText(timeLeft);

                // Change timer color to red when less than 30 seconds remain
                if (seconds <= 30) {
                    timerText.setTextColor(Color.parseColor("#F44336"));
                }
            }

            @Override
            public void onFinish() {
                isTimeUp = true;
                timerText.setText("Time: 00:00");
                timerText.setTextColor(Color.parseColor("#F44336"));
                
                // Disable all remaining unanswered questions
                for (int i = 0; i < radioGroups.length; i++) {
                    if (!answered[i]) {
                        for (int j = 0; j < radioGroups[i].getChildCount(); j++) {
                            radioGroups[i].getChildAt(j).setEnabled(false);
                        }
                    }
                }
                
                // Proceed to final screen
                proceedToFinalScreen();
            }
        }.start();
    }

    private void updateScore() {
        scoreText.setText("Score: " + correctAnswers + "/10");
    }

    private void checkProgress() {
        // Count answered questions
        int answeredCount = 0;
        for (boolean isAnswered : answered) {
            if (isAnswered) answeredCount++;
        }

        // If all questions are answered, proceed to final screen
        if (answeredCount == 10) {
            proceedToFinalScreen();
        }
    }

    private void proceedToFinalScreen() {
        // Cancel timer if it's still running
        if (timer != null) {
            timer.cancel();
        }

        Intent intent = new Intent(QuestionScreen.this, FinalyScreen.class);
        intent.putExtra("FullName", fullName);
        intent.putExtra("Email", email);
        intent.putExtra("Score", correctAnswers);
        intent.putExtra("TimeUp", isTimeUp);
        intent.putExtra("HasWon", correctAnswers >= 6);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }
}