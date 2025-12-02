package com.example.lab2duytruong;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AnimationActivity extends AppCompatActivity {
    private ImageView ivElephant;
    private Button btnAlpha, btnScale, btnTrans, btnRotate, btnRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ivElephant = findViewById(R.id.ivElephant);
        btnAlpha = findViewById(R.id.btnAlpha);
        btnScale = findViewById(R.id.btnScale);
        btnTrans = findViewById(R.id.btnTrans);
        btnRotate = findViewById(R.id.btnRotate);
        btnRandom = findViewById(R.id.btnRandom);
        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(1000);
                alphaAnimation.setRepeatCount(1);
                alphaAnimation.setRepeatMode(Animation.REVERSE);
                ivElephant.startAnimation(alphaAnimation);
            }
        });
        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(
                        1.0f, 1.5f,
                        1.0f, 1.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                );
                scaleAnimation.setDuration(1000);
                scaleAnimation.setRepeatCount(1);
                scaleAnimation.setRepeatMode(Animation.REVERSE);
                ivElephant.startAnimation(scaleAnimation);
            }
        });
        btnTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAnimation translateAnimation = new TranslateAnimation(
                        0, 200,
                        0, 0
                );
                translateAnimation.setDuration(1000);
                translateAnimation.setRepeatCount(1);
                translateAnimation.setRepeatMode(Animation.REVERSE);
                ivElephant.startAnimation(translateAnimation);
            }
        });
        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RotateAnimation rotateAnimation = new RotateAnimation(
                        0, 360,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                );
                rotateAnimation.setDuration(1000);
                ivElephant.startAnimation(rotateAnimation);
            }
        });
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomAnimation = (int) (Math.random() * 4);
                switch (randomAnimation) {
                    case 0:
                        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                        alphaAnimation.setDuration(1000);
                        alphaAnimation.setRepeatCount(1);
                        alphaAnimation.setRepeatMode(Animation.REVERSE);
                        ivElephant.startAnimation(alphaAnimation);
                        break;
                    case 1:
                        ScaleAnimation scaleAnimation = new ScaleAnimation(
                                1.0f, 1.5f,
                                1.0f, 1.5f,
                                Animation.RELATIVE_TO_SELF, 0.5f,
                                Animation.RELATIVE_TO_SELF, 0.5f
                        );
                        scaleAnimation.setDuration(1000);
                        scaleAnimation.setRepeatCount(1);
                        scaleAnimation.setRepeatMode(Animation.REVERSE);
                        ivElephant.startAnimation(scaleAnimation);
                        break;

                    case 2:
                        TranslateAnimation translateAnimation = new TranslateAnimation(
                                0, 200,
                                0, 0
                        );
                        translateAnimation.setDuration(1000);
                        translateAnimation.setRepeatCount(1);
                        translateAnimation.setRepeatMode(Animation.REVERSE);
                        ivElephant.startAnimation(translateAnimation);
                        break;

                    case 3:
                        RotateAnimation rotateAnimation = new RotateAnimation(
                                0, 360,
                                Animation.RELATIVE_TO_SELF, 0.5f,
                                Animation.RELATIVE_TO_SELF, 0.5f
                        );
                        rotateAnimation.setDuration(1000);
                        ivElephant.startAnimation(rotateAnimation);
                        break;
                }
            }
        });
    }
}

