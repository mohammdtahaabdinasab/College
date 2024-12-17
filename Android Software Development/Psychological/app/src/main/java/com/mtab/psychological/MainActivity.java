package com.mtab.psychological;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView name = findViewById(R.id.name);
        TextView date = findViewById(R.id.date);
        TextView error = findViewById(R.id.TeViewError);

        Button btnlog = findViewById(R.id.btnlogin);

        btnlog.setOnClickListener(view -> {
            if (name.getText().toString().isBlank() || date.getText().toString().isBlank()) {
                error.setText("You must enter your information !");
            }
            else {
                Intent intent = new Intent(MainActivity.this, PsychologicalTest.class);
                intent.putExtra("username", name.getText().toString());
                intent.putExtra("date", date.getText().toString());
                startActivity(intent);
                finish();
            }

        });
    }

}