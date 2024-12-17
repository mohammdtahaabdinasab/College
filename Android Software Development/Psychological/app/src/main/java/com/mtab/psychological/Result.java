package com.mtab.psychological;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent getintent = getIntent();
        String names = getintent.getStringExtra("usernames");
        String datess = getintent.getStringExtra("dates");
        String scores = getintent.getStringExtra("scores");

        TextView writename = findViewById(R.id.TextName);
        TextView writedate = findViewById(R.id.TextDate);
        TextView writescore = findViewById(R.id.TextScore);
        TextView writedescription = findViewById(R.id.TextDescription);

        writename.setText(names);
        writedate.setText(datess);
        writescore.setText(writescore.getText().toString()+" : "+scores);

        if (Integer.parseInt(scores) >= 70){
            writedescription.setText("you have good mind");
        } else if (Integer.parseInt(scores) <= 70 && Integer.parseInt(scores) > 50) {
            writedescription.setText("you must talk about your problem with psychologist");
        }
        else if (Integer.parseInt(scores) <= 50 && Integer.parseInt(scores) > 30) {
            writedescription.setText("you must go to the doctor");
        }
        else if (Integer.parseInt(scores) <= 30){
            writedescription.setText("you must go to the hospital");
        }
        else {
            writedescription.setText("i don't know what's happened");
        }

    }
}