package com.example.lab2duytruong;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class QuickCallActivity extends AppCompatActivity {
    private LinearLayout btnMom, btnDad, btnCrush, btnBestFriend;
    private Button btnAlpha, btnScale, btnTrans, btnRotate, btnRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_call);
        btnMom = findViewById(R.id.btnMom);
        btnDad = findViewById(R.id.btnDad);
        btnCrush = findViewById(R.id.btnCrush);
        btnBestFriend = findViewById(R.id.btnBestFriend);
        btnAlpha = findViewById(R.id.btnAlpha);
        btnScale = findViewById(R.id.btnScale);
        btnTrans = findViewById(R.id.btnTrans);
        btnRotate = findViewById(R.id.btnRotate);
        btnRandom = findViewById(R.id.btnRandom);
        btnMom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall("Mom", "0123456789");
            }
        });

        btnDad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall("Dad", "0987654321");
            }
        });

        btnCrush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall("Crush", "0111222333");
            }
        });

        btnBestFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall("Best friend", "0999888777");
            }
        });
        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyAlphaAnimationToAll();
            }
        });
        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyScaleAnimationToAll();
            }
        });

        btnTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyTranslateAnimationToAll();
            }
        });

        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyRotateAnimationToAll();
            }
        });
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applyRandomAnimationToAll();
            }
        });
    }
    private void applyAlphaAnimationToAll() {
        applyAlphaAnimation(btnMom);
        applyAlphaAnimation(btnDad);
        applyAlphaAnimation(btnCrush);
        applyAlphaAnimation(btnBestFriend);
    }

    private void applyScaleAnimationToAll() {
        applyScaleAnimation(btnMom);
        applyScaleAnimation(btnDad);
        applyScaleAnimation(btnCrush);
        applyScaleAnimation(btnBestFriend);
    }

    private void applyTranslateAnimationToAll() {
        applyTranslateAnimation(btnMom);
        applyTranslateAnimation(btnDad);
        applyTranslateAnimation(btnCrush);
        applyTranslateAnimation(btnBestFriend);
    }

    private void applyRotateAnimationToAll() {
        applyRotateAnimation(btnMom);
        applyRotateAnimation(btnDad);
        applyRotateAnimation(btnCrush);
        applyRotateAnimation(btnBestFriend);
    }

    private void applyRandomAnimationToAll() {
        int randomAnimation = (int) (Math.random() * 4);

        switch (randomAnimation) {
            case 0:
                applyAlphaAnimationToAll();
                break;
            case 1:
                applyScaleAnimationToAll();
                break;
            case 2:
                applyTranslateAnimationToAll();
                break;
            case 3:
                applyRotateAnimationToAll();
                break;
        }
    }
    private void applyAlphaAnimation(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setRepeatCount(1);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(alphaAnimation);
    }

    private void applyScaleAnimation(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1.0f, 1.2f,
                1.0f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        scaleAnimation.setDuration(500);
        scaleAnimation.setRepeatCount(1);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(scaleAnimation);
    }
    private void applyRotateAnimation(View view) {
        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotateAnimation.setDuration(500);
        view.startAnimation(rotateAnimation);
    }
    private void applyTranslateAnimation(View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(
                0, 100,
                0, 0
        );
        translateAnimation.setDuration(500);
        translateAnimation.setRepeatCount(1);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        view.startAnimation(translateAnimation);
    }
    private void makeCall(String contactName, String phoneNumber) {
        Toast.makeText(this, "Calling " + contactName + "...", Toast.LENGTH_SHORT).show();
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(callIntent);
    }
}

