package com.example.econest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class NavigationMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);

        View createPostFeature = findViewById(R.id.create_post);

        createPostFeature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View createPostFeature) {
                startActivity();
            }
        });
    }

    private void startActivity() {
        Intent intent = new Intent(this, CreatePostActivity.class);
        startActivity(intent);
    }
}