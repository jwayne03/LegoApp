package com.wayne.legoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSearch = findViewById(R.id.btnSearch);
        Button btnSettings = findViewById(R.id.btnSettings);
        Button btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(listener);
        btnSearch.setOnClickListener(listener);
        btnSettings.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();

            switch (id) {
                case R.id.btnRegister:
                    Log.d("onClick: ", "You've clicked the button REGISTER");
                    Intent intentThirdActivity = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(intentThirdActivity);
                    break;
                case R.id.btnSearch:
                    Log.d("onClick: ", "You've clicked the button SEARCH");
                    break;
                case R.id.btnSettings:
                    Log.d("onClick: ", "You've clicked the button SETTINGS");
                    Intent intentSecondActivity = new Intent(MainActivity.this, SettingsActivity.class);
                    startActivity(intentSecondActivity);
            }
        }
    };
}