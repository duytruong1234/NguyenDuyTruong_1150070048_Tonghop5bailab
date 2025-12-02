package com.example.teofirstappduytruong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Lab2MenuActivity extends AppCompatActivity {

    private Button btnGoToSplash, btnGoToProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_menu);
        btnGoToSplash = findViewById(R.id.btnGoToSplash);
        btnGoToProfile = findViewById(R.id.btnGoToProfile);
        btnGoToSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab2MenuActivity.this, MOO1ActSplash.class);
                startActivity(intent);
            }
        });
        btnGoToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab2MenuActivity.this, M001ActProfile.class);
                startActivity(intent);
            }
        });
    }
}

