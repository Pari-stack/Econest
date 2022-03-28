package com.example.econest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {
    //Declaration section
    EditText email, password;
    FirebaseAuth mAuth;
    Button btn_login, btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        email = (EditText) findViewById(R.id.et_email);
        password = (EditText) findViewById(R.id.enter_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        mAuth = FirebaseAuth.getInstance();  //Getting instances of FirebaseAuth
        btn_signup = (Button) findViewById(R.id.no_account);

        btn_login.setOnClickListener(v -> {
        String eml = email.getText().toString();
        String pass = password.getText().toString();
        if(eml.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please fill in the required fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(eml).matches()) { //email should be valid
            email.setError("Enter a valid email address.");
            email.requestFocus();
            return;
        }
        if(pass.isEmpty()) { //if password is empty
            password.setError("Please fill in the required fields.");
            password.requestFocus();
            return;
        }
        if(pass.length()<6) { //if password length is less than 6
            Toast.makeText(getApplicationContext(), "Length of password must be greater than 6.", Toast.LENGTH_SHORT).show();
            password.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(eml,pass).addOnCompleteListener(task -> { //if success, go to home page
            if(task.isSuccessful()) {
                startActivity(new Intent(LogIn.this, Home.class));
            }
            else { //otherwise throw error message
                Toast.makeText(LogIn.this, "Please Check Your Login Credentials", Toast.LENGTH_SHORT).show();
            }

        });
    }); //sign up instead
        btn_signup.setOnClickListener(v -> startActivity(new Intent(LogIn.this,MainActivity3.class )));
}

    }

