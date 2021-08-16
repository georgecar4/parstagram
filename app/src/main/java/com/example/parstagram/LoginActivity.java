package com.example.parstagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.FindCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    public static final String  TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);




        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick login button" );
                String username =etUsername.getText().toString();
                String password =etPassword.getText().toString();
                loginUser(username,password);

            }
        });
        loginPersistence();
    }

    private void loginUser(String username, String password) {
        Log.i(TAG,"Attempting to login user: " + username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e != null){
                    Log.e(TAG,"Issue with login",e);
                    Toast.makeText(LoginActivity.this,"failed login!",Toast.LENGTH_SHORT).show();
                    return;
                }
                goMainActivity();
                Toast.makeText(LoginActivity.this,"Success!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goMainActivity() {
        Intent i =new Intent(this,MainActivity.class);
        startActivity(i);

    }
    private void loginPersistence(){
        ParseUser currentUser = ParseUser.getCurrentUser();

                if (currentUser != null) {
                    Log.i(TAG,"user was lodged in");
                    Toast.makeText(LoginActivity.this,"same user ", Toast.LENGTH_SHORT).show();
                   goMainActivity();

                }
                else{
                    Toast.makeText(LoginActivity.this, "please log in",Toast.LENGTH_SHORT).show();


                }
            }








}
