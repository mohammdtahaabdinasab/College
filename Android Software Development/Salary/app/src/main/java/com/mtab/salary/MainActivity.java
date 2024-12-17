package com.mtab.salary;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView workerName = findViewById(R.id.editTextText);
        TextView workerSalary = findViewById(R.id.editTextNumber);

        TextView resultSalary = findViewById(R.id.result);

        Button calculate = findViewById(R.id.button);
        calculate.setTextColor(Color.WHITE);
        calculate.setOnClickListener(view -> {
            if(!workerName.getText().toString().isEmpty() && !workerSalary.getText().toString().isEmpty()){
                int salary = Integer.parseInt(workerSalary.getText().toString());
                if (salary>= 20000) {
                    salary -= (int) (salary * 0.1825);
                }
                else if (salary >= 10000) {
                    salary -= (int) (salary * 0.175);
                }
                else if (salary <= 7500) {
                    salary += (int) (salary * 0.175);
                }
                salary += (int) (salary * 0.035);
                resultSalary.setText("Your salary is a "+salary);
            }
        });


    }
}