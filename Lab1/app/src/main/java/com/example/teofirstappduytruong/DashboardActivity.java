package com.example.teofirstappduytruong;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DashboardActivity extends AppCompatActivity {

    private CardView cardNewArrival, cardLinkSaved, cardMyHome;
    private CardView cardEyeStream, cardProAccount, cardRecentFiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        cardNewArrival = findViewById(R.id.cardNewArrival);
        cardLinkSaved = findViewById(R.id.cardLinkSaved);
        cardMyHome = findViewById(R.id.cardMyHome);
        cardEyeStream = findViewById(R.id.cardEyeStream);
        cardProAccount = findViewById(R.id.cardProAccount);
        cardRecentFiles = findViewById(R.id.cardRecentFiles);
        cardNewArrival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "New Arrival clicked", Toast.LENGTH_SHORT).show();
            }
        });

        cardLinkSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Link Saved clicked", Toast.LENGTH_SHORT).show();
            }
        });

        cardMyHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "My Home clicked", Toast.LENGTH_SHORT).show();
            }
        });

        cardEyeStream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Eye Stream clicked", Toast.LENGTH_SHORT).show();
            }
        });

        cardProAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Pro Account clicked", Toast.LENGTH_SHORT).show();
            }
        });

        cardRecentFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "Recent Files clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

