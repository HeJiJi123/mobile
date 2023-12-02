package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activitysecond extends AppCompatActivity {

    private View button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitysecond);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, activity_secondone.class);
            startActivity(intent);
        });
    }
}