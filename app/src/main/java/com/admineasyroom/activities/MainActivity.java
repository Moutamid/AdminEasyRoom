package com.admineasyroom.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.admineasyroom.R;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;


public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    Dialog lodingbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.lavender));
        MaterialButton allUserBtn=findViewById(R.id.allUsersBtn);
        MaterialButton feedBackBtn=findViewById(R.id.feedBackBtn);

        allUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AllUsersActivity.class));
            }
        });

        feedBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FeedBackActivity.class));
            }
        });

    }
}


