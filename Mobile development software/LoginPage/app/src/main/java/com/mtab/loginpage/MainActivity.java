package com.mtab.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputUsername,inputPassword;
    private int loginStatus;

    private final String[] _texts = {
            "username field is empty !",
            "password field is empty !",
            "this username not exist !",
            "password not valid !",
            "welcome admin, good luck ❤",
            "Unspecified problem"
    };

    private int login(String Username, String Password){
        if(Username.isEmpty() || Username.isBlank()){
            return 0;
        }
        else if(Password.isEmpty() || Password.isBlank()){
            return 1;
        }
        else {
            String _Username = "admin";
            String _Password = "admin123";
            if (Username.equalsIgnoreCase(_Username) && Password.equals(_Password)) {
                return 4;
            }
            else {
                if (!Username.equalsIgnoreCase(_Username)){
                    return 2;
                }
                else if (Username.equalsIgnoreCase(_Username) && !Password.equals(_Password)) {
                    return 3;
                }
                else {
                    return 5;
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        inputUsername = findViewById(R.id.edteUsername);
        inputPassword = findViewById(R.id.edtePassword);
        Button buttonLogin = findViewById(R.id.btnLogin);
        buttonLogin.setOnClickListener(v -> {
            loginStatus = login(inputUsername.getText().toString(),inputPassword.getText().toString());
            if(loginStatus == 4){
                Intent intent = new Intent(MainActivity.this, AdminPanel.class);
                startActivity(intent);
            }
            Toast.makeText(MainActivity.this, _texts[loginStatus], Toast.LENGTH_SHORT).show();
        });
    }

}