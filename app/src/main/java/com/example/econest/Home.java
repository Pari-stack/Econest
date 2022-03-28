package com.example.econest;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.econest.data.Post;


public class Home extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ViewGroup parent = findViewById(R.id.parent);
        View view = LayoutInflater.from(this).inflate(R.layout.my_custom_toolbar, parent, false);
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(view, lp);

        View menu = findViewById(R.id.menu_btn);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View menu) {
                startActivity2();
            }
        });
            ImageView icon;
            icon = (ImageView) findViewById(R.id.create);

            icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity();
                }
            });
            configureList();

        }

    private void startActivity2() {
        Intent intent = new Intent(this, NavigationMenu.class);
        startActivity(intent);
    }

    private void configureList(){
            RecyclerView recyclerView = findViewById(R.id.list);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new PostViewAdapter(Post.getDummyItems()));

        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        switch (id) {
            //case R.id.my_account:
                //startMyAccount();
                //return true;
            case R.id.create_post:
                handleCreatePost();
                return true;
        }
         return false;
        //home, my_account, create_post, ideas
    }

    private void handleCreatePost() {
        Intent intent = new Intent(this, CreatePostActivity.class);
        startActivity(intent);
    }

    /*private void startMyAccount() {
        Intent intent = new Intent(this, CreatePostActivity.class);
        startActivity(intent);
    }
     */

    private void startActivity() {
            Intent intent = new Intent(this, CreatePostActivity.class);
            startActivity(intent);
        }
    }