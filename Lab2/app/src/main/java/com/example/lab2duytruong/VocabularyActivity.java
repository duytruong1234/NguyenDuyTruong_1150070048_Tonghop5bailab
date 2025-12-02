package com.example.lab2duytruong;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class VocabularyActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        listView = findViewById(R.id.listView);
        String topic = getIntent().getStringExtra("topic");
        if (topic != null) {
            setTitle(topic);
        }

        if (topic != null && topic.equals("Động vật")) {
            words.addAll(Arrays.asList("Cat - Mèo", "Dog - Chó", "Elephant - Voi", "Tiger - Hổ", "Lion - Sư tử", "Bear - Gấu"));
        } else if (topic != null && topic.equals("Trái cây")) {
            words.addAll(Arrays.asList("Apple - Táo", "Banana - Chuối", "Orange - Cam", "Grapes - Nho", "Mango - Xoài", "Watermelon - Dưa hấu"));
        } else if (topic != null && topic.equals("Màu sắc")) {
            words.addAll(Arrays.asList("Red - Đỏ", "Blue - Xanh dương", "Green - Xanh lá", "Yellow - Vàng", "Black - Đen", "White - Trắng"));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, words);
        listView.setAdapter(adapter);
    }
}

