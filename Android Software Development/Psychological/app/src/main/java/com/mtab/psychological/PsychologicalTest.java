package com.mtab.psychological;
import android.content.Intent;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class PsychologicalTest extends AppCompatActivity {

    public int Score = 100;
    public  boolean question1 = false,question2 = false,question3 = false,question4 = false,question5 = false,question6 = false,question7 = false,question8 = false,question9 = false,question10 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psychological_test);

        Intent getintent = getIntent();

        String name = getintent.getStringExtra("username");
        String date = getintent.getStringExtra("date");

        Button btnPre = findViewById(R.id.btnPrevious);

        Button btnNex = findViewById(R.id.btnNext);
        btnPre.setOnClickListener(view -> {
            startActivity(new Intent(PsychologicalTest.this, MainActivity.class));
            finish();
        });

        LinearLayout li1 = findViewById(R.id.lil1);
        LinearLayout li2 = findViewById(R.id.lil2);
        LinearLayout li3 = findViewById(R.id.lil3);
        LinearLayout li4 = findViewById(R.id.lil4);
        LinearLayout li5 = findViewById(R.id.lil5);
        LinearLayout li6 = findViewById(R.id.lil6);
        LinearLayout li7 = findViewById(R.id.lil7);
        LinearLayout li8 = findViewById(R.id.lil8);
        LinearLayout li9 = findViewById(R.id.lil9);
        LinearLayout li10 = findViewById(R.id.lil10);

        CheckBox Checkbox1False = findViewById(R.id.chlil1);
        CheckBox Checkbox1True = findViewById(R.id.chlil2);
        CheckBox Checkbox2False = findViewById(R.id.chlil3);
        CheckBox Checkbox2True = findViewById(R.id.chlil4);
        CheckBox Checkbox3False = findViewById(R.id.chlil5);
        CheckBox Checkbox3True = findViewById(R.id.chlil6);
        CheckBox Checkbox4False = findViewById(R.id.chlil7);
        CheckBox Checkbox4True = findViewById(R.id.chlil8);
        CheckBox Checkbox5False = findViewById(R.id.chlil9);
        CheckBox Checkbox5True = findViewById(R.id.chlil10);
        CheckBox Checkbox6False = findViewById(R.id.chlil11);
        CheckBox Checkbox6True = findViewById(R.id.chlil12);
        CheckBox Checkbox7False = findViewById(R.id.chlil13);
        CheckBox Checkbox7True = findViewById(R.id.chlil14);
        CheckBox Checkbox8False = findViewById(R.id.chlil15);
        CheckBox Checkbox8True = findViewById(R.id.chlil16);
        CheckBox Checkbox9False = findViewById(R.id.chlil17);
        CheckBox Checkbox9True = findViewById(R.id.chlil18);
        CheckBox Checkbox10False = findViewById(R.id.chlil19);
        CheckBox Checkbox10True = findViewById(R.id.chlil20);

        btnNex.setOnClickListener(view -> {

            if (question1 && question2 && question3 && question4 && question5 && question6 && question7 && question8 && question9 && question10){
                Intent intent = new Intent(PsychologicalTest.this, Result.class);
                intent.putExtra("usernames", name);
                intent.putExtra("dates", date);
                intent.putExtra("scores", ""+Score);
                startActivity(intent);
                finish();
            }
            else {
                if(!question1){
                    li1.setBackgroundColor(Color.parseColor("#ffcd00"));
                }
                if(!question2){
                    li2.setBackgroundColor(Color.parseColor("#ffcd00"));
                }
                if(!question3){
                    li3.setBackgroundColor(Color.parseColor("#ffcd00"));
                }
                if(!question4){
                    li4.setBackgroundColor(Color.parseColor("#ffcd00"));
                }
                if(!question5){
                    li5.setBackgroundColor(Color.parseColor("#ffcd00"));
                }
                if(!question6){
                    li6.setBackgroundColor(Color.parseColor("#ffcd00"));
                }
                if(!question7){
                    li7.setBackgroundColor(Color.parseColor("#ffcd00"));
                }
                if(!question8){
                    li8.setBackgroundColor(Color.parseColor("#ffcd00"));
                }
                if(!question9){
                    li9.setBackgroundColor(Color.parseColor("#ffcd00"));
                }
                if(!question10){
                    li10.setBackgroundColor(Color.parseColor("#ffcd00"));
                }
            }
        });

        Checkbox1False.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox1False.isChecked()) {
                Score -= 10;
                li1.setBackgroundColor(Color.GREEN);
                Checkbox1True.setChecked(false);
                question1 = true;
            } else if (!Checkbox1False.isChecked() && !Checkbox1True.isChecked()) {
                Score += 10;
                li1.setBackgroundColor(Color.parseColor("#262A26"));
                question1 = false;
            }
        });

        Checkbox1True.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox1True.isChecked()) {
                li1.setBackgroundColor(Color.RED);
                Checkbox1False.setChecked(false);
                question1 = true;
            } else if (!Checkbox1False.isChecked() && !Checkbox1True.isChecked()) {
                li1.setBackgroundColor(Color.parseColor("#262A26"));
                question1 = false;
            }
        });

        Checkbox2False.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox2False.isChecked()) {
                Score -= 10;
                li2.setBackgroundColor(Color.GREEN);
                Checkbox2True.setChecked(false);
                question2 = true;
            } else if (!Checkbox2False.isChecked() && !Checkbox2True.isChecked()) {
                Score += 10;
                li2.setBackgroundColor(Color.parseColor("#262A26"));
                question2 = false;
            }
        });

        Checkbox2True.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox2True.isChecked()) {
                li2.setBackgroundColor(Color.RED);
                Checkbox2False.setChecked(false);
                question2 = true;
            } else if (!Checkbox2False.isChecked() && !Checkbox2True.isChecked()) {
                li2.setBackgroundColor(Color.parseColor("#262A26"));
                question2 = false;
            }
        });

        Checkbox3False.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox3False.isChecked()) {
                Score -= 10;
                li3.setBackgroundColor(Color.GREEN);
                Checkbox3True.setChecked(false);
                question3 = true;
            } else if (!Checkbox3False.isChecked() && !Checkbox3True.isChecked()) {
                Score += 10;
                li3.setBackgroundColor(Color.parseColor("#262A26"));
                question3 = false;
            }
        });

        Checkbox3True.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox3True.isChecked()) {
                li3.setBackgroundColor(Color.RED);
                Checkbox3False.setChecked(false);
                question3 = true;
            } else if (!Checkbox3False.isChecked() && !Checkbox3True.isChecked()) {
                li3.setBackgroundColor(Color.parseColor("#262A26"));
                question3 = false;
            }
        });

        Checkbox4False.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox4False.isChecked()) {
                Score -= 10;
                li4.setBackgroundColor(Color.GREEN);
                Checkbox4True.setChecked(false);
                question4 = true;
            } else if (!Checkbox4False.isChecked() && !Checkbox4True.isChecked()) {
                Score += 10;
                li4.setBackgroundColor(Color.parseColor("#262A26"));
                question4 = false;
            }
        });

        Checkbox4True.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox4True.isChecked()) {
                li4.setBackgroundColor(Color.RED);
                Checkbox4False.setChecked(false);
                question4 = true;
            } else if (!Checkbox4False.isChecked() && !Checkbox4True.isChecked()) {
                li4.setBackgroundColor(Color.parseColor("#262A26"));
                question4 = false;
            }
        });

        Checkbox5False.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox5False.isChecked()) {
                Score -= 10;
                li5.setBackgroundColor(Color.GREEN);
                Checkbox5True.setChecked(false);
                question5 = true;
            } else if (!Checkbox9False.isChecked() && !Checkbox5True.isChecked()) {
                Score += 10;
                li5.setBackgroundColor(Color.parseColor("#262A26"));
                question5 = false;
            }
        });

        Checkbox5True.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox5True.isChecked()) {
                li5.setBackgroundColor(Color.RED);
                Checkbox5False.setChecked(false);
                question5 = true;
            } else if (!Checkbox5False.isChecked() && !Checkbox5True.isChecked()) {
                li5.setBackgroundColor(Color.parseColor("#262A26"));
                question5 = false;
            }
        });

        Checkbox6False.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox6False.isChecked()) {
                Score -= 10;
                li6.setBackgroundColor(Color.GREEN);
                Checkbox6True.setChecked(false);
                question6 = true;
            } else if (!Checkbox6False.isChecked() && !Checkbox6True.isChecked()) {
                Score += 10;
                li6.setBackgroundColor(Color.parseColor("#262A26"));
                question6 = false;
            }
        });

        Checkbox6True.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox6True.isChecked()) {
                li6.setBackgroundColor(Color.RED);
                Checkbox6False.setChecked(false);
                question6 = true;
            } else if (!Checkbox6False.isChecked() && !Checkbox6True.isChecked()) {
                li6.setBackgroundColor(Color.parseColor("#262A26"));
                question6 = false;
            }
        });

        Checkbox7False.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox7False.isChecked()) {
                Score -= 10;
                li7.setBackgroundColor(Color.GREEN);
                Checkbox7True.setChecked(false);
                question7 = true;
            } else if (!Checkbox7False.isChecked() && !Checkbox7True.isChecked()) {
                Score += 10;
                li7.setBackgroundColor(Color.parseColor("#262A26"));
                question7 = false;
            }
        });

        Checkbox7True.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox7True.isChecked()) {
                li7.setBackgroundColor(Color.RED);
                Checkbox7False.setChecked(false);
                question7 = true;
            } else if (!Checkbox7False.isChecked() && !Checkbox7True.isChecked()) {
                li7.setBackgroundColor(Color.parseColor("#262A26"));
                question7 = false;
            }
        });

        Checkbox8False.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox8False.isChecked()) {
                Score -= 10;
                li8.setBackgroundColor(Color.GREEN);
                Checkbox8True.setChecked(false);
                question8 = true;
            } else if (!Checkbox8False.isChecked() && !Checkbox8True.isChecked()) {
                Score += 10;
                li8.setBackgroundColor(Color.parseColor("#262A26"));
                question8 = false;
            }
        });

        Checkbox8True.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox8True.isChecked()) {
                li8.setBackgroundColor(Color.RED);
                Checkbox8False.setChecked(false);
                question8 = true;
            } else if (!Checkbox8False.isChecked() && !Checkbox8True.isChecked()) {
                li8.setBackgroundColor(Color.parseColor("#262A26"));
                question8 = false;
            }
        });

        Checkbox9False.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox9False.isChecked()) {
                Score -= 10;
                li9.setBackgroundColor(Color.GREEN);
                Checkbox9True.setChecked(false);
                question9 = true;
            } else if (!Checkbox9False.isChecked() && !Checkbox9True.isChecked()) {
                Score += 10;
                li9.setBackgroundColor(Color.parseColor("#262A26"));
                question9 = false;
            }
        });

        Checkbox9True.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox9True.isChecked()) {
                li9.setBackgroundColor(Color.RED);
                Checkbox9False.setChecked(false);
                question9 = true;
            } else if (!Checkbox9False.isChecked() && !Checkbox9True.isChecked()) {
                li9.setBackgroundColor(Color.parseColor("#262A26"));
                question9 = false;
            }
        });

        Checkbox10False.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox10False.isChecked()) {
                Score -= 10;
                li10.setBackgroundColor(Color.GREEN);
                Checkbox10True.setChecked(false);
                question10 = true;
            } else if (!Checkbox10False.isChecked() && !Checkbox10True.isChecked()) {
                Score += 10;
                li10.setBackgroundColor(Color.parseColor("#262A26"));
                question10 = false;
            }
        });

        Checkbox10True.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (Checkbox10True.isChecked()) {
                li10.setBackgroundColor(Color.RED);
                Checkbox10False.setChecked(false);
                question10 = true;
            } else if (!Checkbox10False.isChecked() && !Checkbox10True.isChecked()) {
                li10.setBackgroundColor(Color.parseColor("#262A26"));
                question10 = false;
            }
        });

    }
}