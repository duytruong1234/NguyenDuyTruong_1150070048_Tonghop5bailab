package com.example.lab4duytruong;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class LineChartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LineChartView lineChartView = new LineChartView(this);
        setContentView(lineChartView);
    }
}
