package com.example.econest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Button button;
        button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity2();
            }
        });
    }

    private void startActivity() {
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }

    private void startActivity2() {
        Intent intent2 = new Intent(this, MainActivity3.class);
        startActivity(intent2);
    }
}

