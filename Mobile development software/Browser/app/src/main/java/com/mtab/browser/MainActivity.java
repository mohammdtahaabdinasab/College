package com.mtab.browser;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private EditText searchEditText;
    private TextView creatorTextView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.weviMain);
        searchEditText = findViewById(R.id.edteSearch);
        Button backBtn = findViewById(R.id.btnBack);
        Button forwardBtn = findViewById(R.id.btnForward);
        Button searchBtn = findViewById(R.id.btnSearch);
        creatorTextView = findViewById(R.id.teviCreator);

        webView.setVisibility(View.GONE);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        backBtn.setOnClickListener(v -> {
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                Toast.makeText(MainActivity.this, "No previous page", Toast.LENGTH_SHORT).show();
            }
        });
        
        forwardBtn.setOnClickListener(v -> {
            if (webView.canGoForward()) {
                webView.goForward();
            } else {
                Toast.makeText(MainActivity.this, "No next page", Toast.LENGTH_SHORT).show();
            }
        });
        
        searchBtn.setOnClickListener(v -> {
            navigateToUrl();

            if (creatorTextView.getVisibility() == View.VISIBLE) {
                creatorTextView.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
            }
        });

        searchEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_GO ||
                (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                navigateToUrl();

                if (creatorTextView.getVisibility() == View.VISIBLE) {
                    creatorTextView.setVisibility(View.GONE);
                    webView.setVisibility(View.VISIBLE);
                }

                return true;
            }
            return false;
        });
    }

    private void navigateToUrl() {
        String url = searchEditText.getText().toString().trim();
        if (!url.isEmpty()) {
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://" + url;
            }
            webView.loadUrl(url);
        } else {
            Toast.makeText(this, "Please enter a URL", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}