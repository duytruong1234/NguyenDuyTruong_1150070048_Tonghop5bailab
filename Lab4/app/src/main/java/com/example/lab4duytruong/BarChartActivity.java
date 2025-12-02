package com.example.lab4duytruong;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class BarChartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BarChartView barChartView = new BarChartView(this);
        setContentView(barChartView);
    }
}
