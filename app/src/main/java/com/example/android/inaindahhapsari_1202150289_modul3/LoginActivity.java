package com.example.android.inaindahhapsari_1202150289_modul3;

/**
 * Created by ASUS on 25/02/2018.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText user,pass;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void LoginAction(View view) {
        user = (EditText) findViewById(R.id.txtUsername);
        pass = (EditText) findViewById(R.id.txtPassword);
        String username="EAD";
        String password="MOBILE";
        if (user.getText().toString().equals(username) && pass.getText().toString().equals(password)){
            Toast.makeText(this, "Login Success!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Login Failed, Try Again!", Toast.LENGTH_SHORT).show();
        }
    }
}
