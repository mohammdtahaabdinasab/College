package com.mtab.calculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

public class SplashActivity extends AppCompatActivity {
    
    // Splash screen duration in milliseconds
    private static final int SPLASH_DURATION = 2000;
    
    // GitHub profile URL
    private static final String GITHUB_URL = "https://github.com/mohammdtahaabdinasab";
    
    // Handler for delayed transition
    private Handler handler = new Handler();
    private Runnable transitionRunnable;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Install the splash screen (which we've customized to bypass the default)
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        
        // Tell the splash screen to immediately hide itself
        splashScreen.setKeepOnScreenCondition(() -> false);
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        // Make the status bar and navigation bar transparent if possible
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);
        
        // Find views
        ImageView logoImageView = findViewById(R.id.imageViewLogo);
        TextView titleTextView = findViewById(R.id.textViewTitle);
        ImageButton githubButton = findViewById(R.id.githubButton);
        
        // Set up GitHub button
        githubButton.setOnClickListener(v -> openGitHubProfile());
        
        // Load animations
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        
        // Apply animations
        logoImageView.startAnimation(fadeIn);
        titleTextView.startAnimation(fadeIn);
        
        // Create transition runnable
        transitionRunnable = () -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        };
        
        // Delayed navigation to main activity
        handler.postDelayed(transitionRunnable, SPLASH_DURATION);
    }
    
    /**
     * Open GitHub profile in the browser
     */
    private void openGitHubProfile() {
        // Remove the pending transition to MainActivity
        handler.removeCallbacks(transitionRunnable);
        
        // Open GitHub in browser
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(GITHUB_URL));
        startActivity(browserIntent);
        
        // Finish activity
        finish();
    }
    
    @Override
    protected void onDestroy() {
        // Remove any pending callbacks to prevent leaks
        handler.removeCallbacks(transitionRunnable);
        super.onDestroy();
    }
} 