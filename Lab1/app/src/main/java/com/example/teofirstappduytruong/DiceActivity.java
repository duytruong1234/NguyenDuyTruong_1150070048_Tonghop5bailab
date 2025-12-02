    package com.example.teofirstappduytruong;
    import android.animation.ObjectAnimator;
    import android.os.Bundle;
    import android.view.View;
    import android.view.animation.AccelerateDecelerateInterpolator;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.TextView;
    import androidx.appcompat.app.AppCompatActivity;
    import java.util.Random;

    public class DiceActivity extends AppCompatActivity {

        private TextView tvNumber;
        private ImageView ivDice;
        private Button btnRoll;
        private Random random;
        private int[] diceImages = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dice);
            tvNumber = findViewById(R.id.tvNumber);
            ivDice = findViewById(R.id.ivDice);
            btnRoll = findViewById(R.id.btnRoll);
            random = new Random();
            btnRoll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rollDice();
                }
            });
            ivDice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rollDice();
                }
            });
        }
        private void rollDice() {
            btnRoll.setEnabled(false);
            ivDice.setClickable(false);
            ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(ivDice, "rotation", 0f, 720f);
            rotateAnimator.setDuration(600);
            rotateAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(ivDice, "scaleX", 1f, 1.4f, 1f);
            scaleXAnimator.setDuration(600);
            ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(ivDice, "scaleY", 1f, 1.4f, 1f);
            scaleYAnimator.setDuration(600);
            ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(ivDice, "alpha", 1f, 0.3f, 1f);
            alphaAnimator.setDuration(600);
            rotateAnimator.start();
            scaleXAnimator.start();
            scaleYAnimator.start();
            alphaAnimator.start();
            final int[] counter = {0};
            final Runnable numberChanger = new Runnable() {
                @Override
                public void run() {
                    if (counter[0] < 10) {
                        int tempNum = random.nextInt(6) + 1;
                        tvNumber.setText(String.format("%02d", tempNum));
                        counter[0]++;
                        ivDice.postDelayed(this, 50);
                    }
                }
            };
            numberChanger.run();
            ivDice.postDelayed(new Runnable() {
                @Override
                public void run() {
                    int diceNumber = random.nextInt(6) + 1;
                    tvNumber.setText(String.format("%02d", diceNumber));
                    ivDice.setImageResource(diceImages[diceNumber - 1]);
                    btnRoll.setEnabled(true);
                    ivDice.setClickable(true);
                }
            }, 600);
        }
    }