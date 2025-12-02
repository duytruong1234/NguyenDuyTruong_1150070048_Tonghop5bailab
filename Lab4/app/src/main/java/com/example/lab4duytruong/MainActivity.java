package com.example.lab4duytruong;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TopicAdapter adapter;
    private List<TopicItem> topicItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        topicItems = new ArrayList<>();
        topicItems.add(new TopicItem(R.drawable.anhtruyencuoi, "Học sinh"));

        adapter = new TopicAdapter(topicItems, new TopicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(TopicItem item) {
                if (item.getTitle().equals("Học sinh")) {
                    StoryListFragment storyListFragment = new StoryListFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentContainer, storyListFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                } else {
                    Toast.makeText(MainActivity.this,
                            "Clicked: " + item.getTitle(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
