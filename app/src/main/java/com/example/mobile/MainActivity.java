package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button activityButton;
    private View button_third;
    private View button_two;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityButton = findViewById( R.id.activity_button );
        activityButton.setOnClickListener( v -> {
            Intent intent = new Intent( this, activitysecond.class );
            startActivity( intent );
        } );
    }
}