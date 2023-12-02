package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.activity_button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, activity_second.class);
            startActivity(intent);
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.activity_button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, activity_fourth.class);
            startActivity(intent);
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.activity_button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, activity_third.class);
            startActivity(intent);
        });
    }

    private void startActivities(Intent switcher) {
    }

}