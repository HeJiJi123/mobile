package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class activity_fouthtwo extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fouthtwo);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, activity_main.class);
            startActivity(intent);
        });
    }
}