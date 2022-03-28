package com.example.econest;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity3 extends AppCompatActivity {
       EditText email,password;
       Button registerButton,logInButton;
       FirebaseAuth firebaseAuth;
       @Override
       protected void onCreate(Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
              setContentView(R.layout.activity_main3);

              email = (EditText) findViewById(R.id.et_email);
              password = (EditText) findViewById(R.id.create_password);
              registerButton = (Button) findViewById(R.id.btn_signup);
              logInButton = (Button) findViewById(R.id.have_account);
              firebaseAuth = FirebaseAuth.getInstance();

              registerButton.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                            String email2 = email.getText().toString();
                            String password2 = password.getText().toString();

                            if (TextUtils.isEmpty(email2)) {
                                   Toast.makeText(getApplicationContext(), "Please fill in the required fields", Toast.LENGTH_SHORT).show();
                                   return;
                            }
                            if (TextUtils.isEmpty(password2)) {
                                   Toast.makeText(getApplicationContext(), "Please fill in the required fields", Toast.LENGTH_SHORT).show();
                            }

                            if (password.length() < 6) {
                                   Toast.makeText(getApplicationContext(), "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                            }

                            firebaseAuth.createUserWithEmailAndPassword(email2, password2)
                                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                           @Override
                                           public void onComplete(@NonNull Task<AuthResult> task) {
                                                  if (task.isSuccessful()) {
                                                         startActivity(new Intent(getApplicationContext(), Home.class));
                                                         finish();
                                                  } else {
                                                         Toast.makeText(getApplicationContext(), "E-mail or password is wrong", Toast.LENGTH_SHORT).show();
                                                  }
                                           }
                                    });
                     }
              });
              logInButton.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                            startActivity();
                     }
              });

              /* if (firebaseAuth.getCurrentUser() != null) {
                     startActivity(new Intent(getApplicationContext(), Home.class));
              }
               */
       }

       private void startActivity() {
              Intent intent = new Intent(this, LogIn.class);
              startActivity(intent);
       }


}




