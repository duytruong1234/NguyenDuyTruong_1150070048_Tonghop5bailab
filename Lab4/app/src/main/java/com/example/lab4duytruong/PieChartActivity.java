package com.example.lab4duytruong;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class PieChartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PieChartView pieChartView = new PieChartView(this);
        setContentView(pieChartView);
    }
}
