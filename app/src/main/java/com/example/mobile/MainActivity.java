package com.example.mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private View button_third;
    private View button_two;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToSecondActivity(View view) {
        Intent intent = new Intent(this, activity_second.class);
        startActivity(intent);
    }
    public void goToSecondOneActivity(View view) {
        Intent intent = new Intent(this, activity_secondone.class);
        startActivity(intent);
    }
    public void goToSecondTwoActivity(View view) {
        Intent intent = new Intent(this, activity_fourth.class);
        startActivity(intent);
    }
    public void goToFourthActivity(View view) {
        Intent intent = new Intent(this, activity_fourthone.class);
        startActivity(intent);
    }
    public void goToFourthOneActivity(View view) {
        Intent intent = new Intent(this, activity_fourthtwo.class);
        startActivity(intent);
    }
    public void goToFourthTwoActivity(View view) {
        Intent intent = new Intent(this, activity_main.class);
        startActivity(intent);
    }
    public void goToThirdActivity(View view) {
        Intent intent = new Intent(this, activity_third.class);
        startActivity(intent);
    }

    private void startActivities(Intent switcher) {
    }

}