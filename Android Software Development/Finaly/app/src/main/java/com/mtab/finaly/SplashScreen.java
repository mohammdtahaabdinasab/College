package com.mtab.finaly;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {
    private final int[] Images = {
            R.drawable.icons8_angry_100,
            R.drawable.icons8_bored_100,
            R.drawable.icons8_boring_100,
            R.drawable.icons8_cool_100,
            R.drawable.icons8_crazy_100,
            R.drawable.icons8_disgusting_100,
            R.drawable.icons8_fat_emoji_100,
            R.drawable.icons8_neutral_100,
            R.drawable.icons8_silent_100,
            R.drawable.icons8_sleeping_100,
            R.drawable.icons8_smiling_100,
            R.drawable.icons8_tongue_out_100,
            R.drawable.icons8_uwu_emoji_100,
            R.drawable.icons8_vomited_100,
            R.drawable.icons8_wtf_100
    };

    private final String[] Text = {
        "Your are a angry ?",
        "Your are a bored ?",
        "Your are a boring ?",
        "Your are a cool ?",
        "Your are a crazy ?",
        "Your are a disgusting ?",
        "Your are a fat ?",
        "Your are a neutral ?",
        "Your are a silent ?",
        "Your are a sleeping ?",
        "Your are a smiling ?",
        "Your are a tongue out ?",
        "Your are a poker ?",
        "Your are a sick ?",
        "Your are a stupid ?",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView splashScreenImage = findViewById(R.id.imageView);
        TextView splashScreenRandomText = findViewById(R.id.textViewRandom);

        splashScreenImage.setImageResource(Images[new Random().nextInt(Images.length)]);
        splashScreenRandomText.setText(Text[new Random().nextInt(Text.length)]);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 2000);
    }
}