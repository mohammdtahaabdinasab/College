package com.mtab.calculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView displayTextView;
    private ImageButton themeModeButton;
    private ImageButton githubButton;
    
    // GitHub profile URL
    private static final String GITHUB_URL = "https://github.com/mohammdtahaabdinasab";
    
    // Variables to store operands and operations
    private double firstOperand = 0;
    private double secondOperand = 0;
    private String currentOperation = "";
    private boolean isOperationClicked = false;
    
    // Number formatter
    private DecimalFormat decimalFormat = new DecimalFormat("#.##########");
    
    // Shared preferences
    private SharedPreferences preferences;
    private static final String PREF_NAME = "CalculatorPrefs";
    private static final String THEME_KEY = "theme_mode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Set up theme from preferences
        preferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        int themeMode = preferences.getInt(THEME_KEY, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        AppCompatDelegate.setDefaultNightMode(themeMode);
        
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        // Handle insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        // Initialize display
        displayTextView = findViewById(R.id.displayTextView);
        
        // Initialize theme toggle and GitHub buttons
        themeModeButton = findViewById(R.id.themeModeButton);
        githubButton = findViewById(R.id.githubButton);
        
        themeModeButton.setOnClickListener(view -> toggleTheme());
        githubButton.setOnClickListener(view -> openGitHubProfile());
        
        // Initialize digit buttons
        initializeButton(R.id.zeroButton);
        initializeButton(R.id.oneButton);
        initializeButton(R.id.twoButton);
        initializeButton(R.id.threeButton);
        initializeButton(R.id.fourButton);
        initializeButton(R.id.fiveButton);
        initializeButton(R.id.sixButton);
        initializeButton(R.id.sevenButton);
        initializeButton(R.id.eightButton);
        initializeButton(R.id.nineButton);
        
        // Initialize operation buttons
        initializeButton(R.id.addButton);
        initializeButton(R.id.subtractButton);
        initializeButton(R.id.multiplyButton);
        initializeButton(R.id.divideButton);
        initializeButton(R.id.equalsButton);
        
        // Initialize other buttons
        initializeButton(R.id.clearButton);
        initializeButton(R.id.decimalButton);
        initializeButton(R.id.backspaceButton);
    }
    
    /**
     * Toggle between light and dark theme modes
     */
    private void toggleTheme() {
        int currentMode = AppCompatDelegate.getDefaultNightMode();
        int newMode;
        
        if (currentMode == AppCompatDelegate.MODE_NIGHT_YES) {
            newMode = AppCompatDelegate.MODE_NIGHT_NO;
            Toast.makeText(this, "Light Theme Enabled", Toast.LENGTH_SHORT).show();
        } else {
            newMode = AppCompatDelegate.MODE_NIGHT_YES;
            Toast.makeText(this, "Dark Theme Enabled", Toast.LENGTH_SHORT).show();
        }
        
        // Save the theme preference
        preferences.edit().putInt(THEME_KEY, newMode).apply();
        
        // Apply the theme
        AppCompatDelegate.setDefaultNightMode(newMode);
    }
    
    /**
     * Open GitHub profile in the browser
     */
    private void openGitHubProfile() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(GITHUB_URL));
        startActivity(browserIntent);
    }
    
    private void initializeButton(int buttonId) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        
        // Handle number buttons
        if (viewId == R.id.zeroButton || viewId == R.id.oneButton || 
            viewId == R.id.twoButton || viewId == R.id.threeButton || 
            viewId == R.id.fourButton || viewId == R.id.fiveButton || 
            viewId == R.id.sixButton || viewId == R.id.sevenButton || 
            viewId == R.id.eightButton || viewId == R.id.nineButton) {
            
            handleNumberClick(((Button) view).getText().toString());
        }
        // Handle operation buttons
        else if (viewId == R.id.addButton || viewId == R.id.subtractButton || 
                 viewId == R.id.multiplyButton || viewId == R.id.divideButton) {
            
            handleOperationClick(((Button) view).getText().toString());
        }
        // Handle equals button
        else if (viewId == R.id.equalsButton) {
            calculateResult();
        }
        // Handle clear button
        else if (viewId == R.id.clearButton) {
            clearCalculator();
        }
        // Handle decimal button
        else if (viewId == R.id.decimalButton) {
            handleDecimalClick();
        }
        // Handle backspace button
        else if (viewId == R.id.backspaceButton) {
            handleBackspaceClick();
        }
    }
    
    private void handleNumberClick(String number) {
        if (displayTextView.getText().toString().equals("0") || isOperationClicked) {
            displayTextView.setText(number);
            isOperationClicked = false;
        } else {
            displayTextView.append(number);
        }
    }
    
    private void handleOperationClick(String operation) {
        if (!currentOperation.isEmpty()) {
            calculateResult();
        }
        
        firstOperand = Double.parseDouble(displayTextView.getText().toString());
        currentOperation = operation;
        isOperationClicked = true;
    }
    
    private void handleDecimalClick() {
        if (isOperationClicked) {
            displayTextView.setText("0.");
            isOperationClicked = false;
        } else if (!displayTextView.getText().toString().contains(".")) {
            displayTextView.append(".");
        }
    }
    
    private void handleBackspaceClick() {
        String currentText = displayTextView.getText().toString();
        if (currentText.length() > 1) {
            displayTextView.setText(currentText.substring(0, currentText.length() - 1));
        } else {
            displayTextView.setText("0");
        }
    }
    
    private void calculateResult() {
        if (currentOperation.isEmpty()) {
            return;
        }
        
        secondOperand = Double.parseDouble(displayTextView.getText().toString());
        double result = 0;
        
        switch (currentOperation) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "×":
                result = firstOperand * secondOperand;
                break;
            case "÷":
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                } else {
                    displayTextView.setText("Error");
                    currentOperation = "";
                    isOperationClicked = true;
                    return;
                }
                break;
        }
        
        // Format and display the result
        displayTextView.setText(formatResult(result));
        
        // Reset for next calculation
        firstOperand = result;
        currentOperation = "";
        isOperationClicked = true;
    }
    
    private String formatResult(double result) {
        // Check if the result is a whole number
        if (result == (long) result) {
            return String.valueOf((long) result);
        } else {
            return decimalFormat.format(result);
        }
    }
    
    private void clearCalculator() {
        displayTextView.setText("0");
        firstOperand = 0;
        secondOperand = 0;
        currentOperation = "";
        isOperationClicked = false;
    }
}