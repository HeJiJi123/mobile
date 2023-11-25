package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activitysecondone extends AppCompatActivity {
    private EditText editTextPhone;
    private EditText editTextTextPassword;
    private Button authButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitysecondone);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        authButton = findViewById(R.id.authButton);

        authButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = editTextPhone.getText().toString();
                String Password = editTextTextPassword.getText().toString();
            }
        });
    }
}