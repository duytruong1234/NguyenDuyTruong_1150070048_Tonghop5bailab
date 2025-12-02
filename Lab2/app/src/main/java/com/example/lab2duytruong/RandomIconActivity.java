package com.example.lab2duytruong;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import java.util.Random;
public class RandomIconActivity extends AppCompatActivity {
    ImageView[] emojiViews;
    CardView[] cardViews;
    Random random;
    int[] emojiArray;
    Button randomizeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_icon);
        random = new Random();
        emojiArray = new int[]{
                android.R.drawable.ic_menu_camera,
                android.R.drawable.ic_menu_gallery,
                android.R.drawable.ic_menu_call,
                android.R.drawable.ic_menu_share,
                android.R.drawable.ic_menu_search,
                android.R.drawable.ic_menu_send,
                android.R.drawable.ic_menu_edit,
                android.R.drawable.ic_menu_save,
                android.R.drawable.ic_menu_info_details,
                android.R.drawable.ic_menu_help
        };
        emojiViews = new ImageView[9];
        cardViews = new CardView[9];
        emojiViews[0] = findViewById(R.id.emoji1);
        emojiViews[1] = findViewById(R.id.emoji2);
        emojiViews[2] = findViewById(R.id.emoji3);
        emojiViews[3] = findViewById(R.id.emoji4);
        emojiViews[4] = findViewById(R.id.emoji5);
        emojiViews[5] = findViewById(R.id.emoji6);
        emojiViews[6] = findViewById(R.id.emoji7);
        emojiViews[7] = findViewById(R.id.emoji8);
        emojiViews[8] = findViewById(R.id.emoji9);

        cardViews[0] = findViewById(R.id.card1);
        cardViews[1] = findViewById(R.id.card2);
        cardViews[2] = findViewById(R.id.card3);
        cardViews[3] = findViewById(R.id.card4);
        cardViews[4] = findViewById(R.id.card5);
        cardViews[5] = findViewById(R.id.card6);
        cardViews[6] = findViewById(R.id.card7);
        cardViews[7] = findViewById(R.id.card8);
        cardViews[8] = findViewById(R.id.card9);
        for (int i = 0; i < 9; i++) {
            emojiViews[i].setImageResource(emojiArray[i]);
        }
        for (int i = 0; i < 9; i++) {
            final int index = i;
            cardViews[i].setOnClickListener(v -> {
                int randomIndex = random.nextInt(emojiArray.length);
                emojiViews[index].setImageResource(emojiArray[randomIndex]);
            });
        }

        randomizeButton = findViewById(R.id.randomizeButton);
        randomizeButton.setOnClickListener(v -> {
            for (int i = 0; i < 9; i++) {
                int randomIndex = random.nextInt(emojiArray.length);
                emojiViews[i].setImageResource(emojiArray[randomIndex]);
            }
        });
    }
}
