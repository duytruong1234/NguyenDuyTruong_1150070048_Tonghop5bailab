package com.example.teofirstappduytruong;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MOO1ActSplash extends AppCompatActivity {
    private LinearLayout splashLayout;
    private ImageView ivLogo;
    private ProgressBar progressBar;
    private TextView tvLoading, tvName;
    private Random random;
    private int[] colors = {
            Color.parseColor("#1A237E"),
            Color.parseColor("#0D47A1"),
            Color.parseColor("#1B5E20"),
            Color.parseColor("#4A148C"),
            Color.parseColor("#BF360C"),
            Color.parseColor("#263238"),
            Color.parseColor("#311B92"),
            Color.parseColor("#880E4F"),
            Color.parseColor("#01579B"),
            Color.parseColor("#004D40")
    };
    private int[] icons = {
            android.R.drawable.ic_menu_camera,
            android.R.drawable.ic_menu_gallery,
            android.R.drawable.ic_menu_compass,
            android.R.drawable.ic_menu_agenda,
            android.R.drawable.ic_menu_call,
            android.R.drawable.ic_menu_send,
            android.R.drawable.ic_menu_view,
            android.R.drawable.ic_menu_info_details,
            android.R.drawable.ic_dialog_email,
            android.R.drawable.ic_dialog_map
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m001_act_splash);

        random = new Random();

        splashLayout = findViewById(R.id.splashLayout);
        ivLogo = findViewById(R.id.ivLogo);
        progressBar = findViewById(R.id.progressBar);
        tvLoading = findViewById(R.id.tvLoading);
        tvName = findViewById(R.id.tvName);
        changeRandomColorAndIcon();
        Animation zoomIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        ivLogo.startAnimation(zoomIn);
        tvLoading.startAnimation(zoomIn);
        tvName.startAnimation(zoomIn);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MOO1ActSplash.this, PhoneActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    private void changeRandomColorAndIcon() {
        int randomColor = colors[random.nextInt(colors.length)];
        splashLayout.setBackgroundColor(randomColor);
        int randomIcon = icons[random.nextInt(icons.length)];
        ivLogo.setImageResource(randomIcon);
    }
}