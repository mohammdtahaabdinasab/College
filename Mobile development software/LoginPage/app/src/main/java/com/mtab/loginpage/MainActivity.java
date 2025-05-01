package com.mtab.loginpage;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputUsername,inputPassword;

    private final String[] _texts = {
            "username field is empty !",
            "password field is empty !",
            "this username not exist !",
            "password not valid !",
            "welcome admin, good luck ❤",
            "Unspecified problem"
    };

    private String login(String Username, String Password){
        if(Username.isEmpty() || Username.isBlank()){
            return _texts[0];
        }
        else if(Password.isEmpty() || Password.isBlank()){
            return _texts[1];
        }
        else {
            String _Username = "admin";
            String _Password = "admin123";
            if (Username.equalsIgnoreCase(_Username) && Password.equals(_Password)) {
                return _texts[4];
            }
            else {
                if (!Username.equalsIgnoreCase(_Username)){
                    return _texts[2];
                }
                else if (Username.equalsIgnoreCase(_Username) && !Password.equals(_Password)) {
                    return _texts[3];
                }
                else {
                    return _texts[5];
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
        buttonLogin.setOnClickListener(v -> Toast.makeText(MainActivity.this, login(inputUsername.getText().toString(),inputPassword.getText().toString()), Toast.LENGTH_SHORT).show());
    }

}