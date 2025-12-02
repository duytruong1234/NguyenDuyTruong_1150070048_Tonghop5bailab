package com.example.lab2duytruong;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VocabularyMainActivity extends AppCompatActivity {

    LinearLayout btnAnimals, btnFruits, btnColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary_main);

        btnAnimals = findViewById(R.id.btnAnimals);
        btnFruits = findViewById(R.id.btnFruits);
        btnColors = findViewById(R.id.btnColors);

        btnAnimals.setOnClickListener(v -> {
            Toast.makeText(VocabularyMainActivity.this, "Chủ đề: Động vật - Cat, Dog, Elephant, Tiger", Toast.LENGTH_SHORT).show();
            openTopic("Động vật");
        });

        btnFruits.setOnClickListener(v -> {
            Toast.makeText(VocabularyMainActivity.this, "Chủ đề: Trái cây - Apple, Banana, Orange, Grapes", Toast.LENGTH_SHORT).show();
            openTopic("Trái cây");
        });

        btnColors.setOnClickListener(v -> {
            Toast.makeText(VocabularyMainActivity.this, "Chủ đề: Màu sắc - Red, Blue, Green, Yellow", Toast.LENGTH_SHORT).show();
            openTopic("Màu sắc");
        });
    }

    private void openTopic(String topic) {
        Intent intent = new Intent(this, VocabularyActivity.class);
        intent.putExtra("topic", topic);
        startActivity(intent);
    }
}
