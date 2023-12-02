package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activitysecondtwo extends AppCompatActivity {
    private EditText editTextPhone2;
    private EditText editTextTextPassword2;
    private EditText editTextDate;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitysecondtwo);
        editTextPhone2 = findViewById(R.id.editTextPhone2);
        editTextDate = findViewById(R.id.editTextDate);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);
        registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String phoneNumber = editTextPhone2.getText().toString();
              String BirthDate = editTextDate.getText().toString();
              String Password = editTextTextPassword2.getText().toString();
            }
        });
    }
}