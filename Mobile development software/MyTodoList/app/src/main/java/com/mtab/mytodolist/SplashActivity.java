package com.mtab.mytodolist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 2000;
    
    private static final String PREF_NAME = "MyTodoPrefs";
    private static final String KEY_FIRST_RUN = "isFirstRun";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logoImageView = findViewById(R.id.image_logo);
        TextView appNameTextView = findViewById(R.id.text_app_name);

        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        logoImageView.startAnimation(fadeInAnimation);
        appNameTextView.startAnimation(fadeInAnimation);

        checkFirstRun();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                
                finish();
            }
        }, SPLASH_DURATION);
    }
    
    private void checkFirstRun() {
        SharedPreferences prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        boolean isFirstRun = prefs.getBoolean(KEY_FIRST_RUN, true);
        
        if (isFirstRun) {
            addSampleData();
            
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(KEY_FIRST_RUN, false);
            editor.apply();
        }
    }
    
    private void addSampleData() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String today = dateFormat.format(Calendar.getInstance().getTime());
        
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_YEAR, 1);
        String tomorrowStr = dateFormat.format(tomorrow.getTime());
        
        Calendar afterTomorrow = Calendar.getInstance();
        afterTomorrow.add(Calendar.DAY_OF_YEAR, 2);
        String afterTomorrowStr = dateFormat.format(afterTomorrow.getTime());
        
        dbHelper.insertTodo(new Todo("ارائه پروژه اندروید", "آماده کردن پروژه برای دمو در کلاس", today));
        dbHelper.insertTodo(new Todo("خرید مواد غذایی", "نان، شیر، تخم مرغ، میوه", tomorrowStr));
        dbHelper.insertTodo(new Todo("مطالعه فصل 5 کتاب", "خواندن و یادداشت‌برداری از فصل 5 کتاب برنامه‌نویسی اندروید", afterTomorrowStr));
    }
} 