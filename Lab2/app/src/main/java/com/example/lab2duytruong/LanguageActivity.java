package com.example.lab2duytruong;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        TextView btnVietnamese = findViewById(R.id.btnVietnamese);
        TextView btnEnglish = findViewById(R.id.btnEnglish);
        TextView btnFrench = findViewById(R.id.btnFrench);
        btnVietnamese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("vi");
            }
        });
        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("en");
            }
        });
        btnFrench.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("fr");
            }
        });
    }
    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        recreate();
    }
}
