package com.wayne.legoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TokenActivity extends AppCompatActivity {

    TextView enterToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        enterToken = findViewById(R.id.txtViewToken);

        Button btnDeleteApiKey = findViewById(R.id.btnDeleteApiKey);
        btnDeleteApiKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);
                SharedPreferences.Editor ed = prefs.edit();
                ed.putString("token" , " ");
                finishAffinity();
                ed.apply();
            }
        });

        Button btnCheckApiKey = findViewById(R.id.btnChkApiKey);
        btnCheckApiKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);

                SharedPreferences.Editor ed = prefs.edit();
                String token = enterToken.getText().toString();

                if (!token.isEmpty()) {
                    Intent intent = new Intent(TokenActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                ed.putString("enterToken", token);
                ed.apply();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);

        String token = prefs.getString("enterToken", " ");
        enterToken.setText(token);
    }

}