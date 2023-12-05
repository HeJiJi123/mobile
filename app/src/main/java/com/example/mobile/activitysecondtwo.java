package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activitysecondtwo extends AppCompatActivity {

    private EditText editTextTextPassword2;
    private Button registerButton;
    private EditText editTexText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_activitysecondtwo );
        editTexText = findViewById( R.id.editTextText );
        editTextTextPassword2 = findViewById( R.id.editTextTextPassword2 );
        registerButton = findViewById( R.id.registerButton );
        registerButton.setOnClickListener( v -> {
            Intent intent = new Intent( this, activity_secondone.class );
            startActivity( intent );
            registerButton.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String EditTexText = editTexText.getText().toString();
                    String Password = editTextTextPassword2.getText().toString();
                    finish();
                }
            } );
        } );
    }
}