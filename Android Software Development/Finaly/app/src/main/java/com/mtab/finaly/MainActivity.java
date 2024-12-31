package com.mtab.finaly;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Initialize database helper
        dbHelper = new DatabaseHelper(this);

        LinearLayout mainScreenLilName = findViewById(R.id.lilName);
        LinearLayout mainScreenLilEmail = findViewById(R.id.lilEmail);

        TextView mainScreenTextViewWarning = findViewById(R.id.textWarning);
        TextView mainScreenTextViewFullName = findViewById(R.id.editTextText);
        TextView mainScreenTextViewEmail = findViewById(R.id.editTextTextEmailAddress);
        Button mainScreenButtonRegister = findViewById(R.id.buttonRegister);

        mainScreenTextViewEmail.setOnClickListener(view -> {
            mainScreenLilEmail.setBackgroundColor(Color.WHITE);
        });

        mainScreenTextViewFullName.setOnClickListener(view -> {
            mainScreenLilName.setBackgroundColor(Color.WHITE);
        });

        mainScreenButtonRegister.setOnClickListener(view -> {
            String email = mainScreenTextViewEmail.getText().toString();
            String fullName = mainScreenTextViewFullName.getText().toString();

            if (fullName.isBlank() || email.isBlank()) {
                if (fullName.isBlank()) {
                    mainScreenLilName.setBackgroundColor(Color.RED);
                }
                if (email.isBlank()) {
                    mainScreenLilEmail.setBackgroundColor(Color.RED);
                }
                mainScreenTextViewWarning.setText("You must enter your information!");
            } else if (dbHelper.isEmailExists(email)) {
                mainScreenLilEmail.setBackgroundColor(Color.RED);
                mainScreenTextViewWarning.setText("This email is already registered!");
            } else {
                // Add user to database
                if (dbHelper.addUser(email)) {
                    Intent intent = new Intent(MainActivity.this, QuestionScreen.class);
                    intent.putExtra("FullName", fullName);
                    intent.putExtra("Email", email);
                    startActivity(intent);
                } else {
                    mainScreenTextViewWarning.setText("Error registering user. Please try again.");
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }
}