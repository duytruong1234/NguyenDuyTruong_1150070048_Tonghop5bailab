package com.example.teofirstappduytruong;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.annotation.NonNull;

public class M001ActProfile extends AppCompatActivity {

    private ImageView ivProfilePicture;
    private ImageView ivCallIcon;
    private TextView tvProfileName;
    private TextView tvProfileEmail;
    private TextView tvProfilePhone;
    private static final int REQUEST_CALL_PERMISSION = 100;
    private String pendingPhoneToCall = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m001_act_profile);
        ivProfilePicture = findViewById(R.id.ivProfilePicture);
        ivCallIcon = findViewById(R.id.ivCallIcon);
        tvProfileName = findViewById(R.id.tvProfileName);
        tvProfileEmail = findViewById(R.id.tvProfileEmail);
        tvProfilePhone = findViewById(R.id.tvProfilePhone);
        tvProfileName.setText("Ali Connors");
        tvProfileEmail.setText("aliconnors@example.com");
        tvProfilePhone.setText("(650) 555-1234");
        ivCallIcon.setOnClickListener(v -> {
            String phone = tvProfilePhone.getText().toString().trim();
            final String normalized = phone.replaceAll("[^+0-9]", "");
            if (normalized.isEmpty()) {
                Toast.makeText(M001ActProfile.this, "Số điện thoại không hợp lệ", Toast.LENGTH_SHORT).show();
                return;
            }
            if (ContextCompat.checkSelfPermission(M001ActProfile.this, Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + normalized));
                startActivity(callIntent);
            } else {
                pendingPhoneToCall = normalized;
                ActivityCompat.requestPermissions(M001ActProfile.this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        REQUEST_CALL_PERMISSION);
            }
        });
        ivProfilePicture.setOnClickListener(v -> {
            Intent intent = new Intent(M001ActProfile.this, PhoneActivity.class);
            String phone = tvProfilePhone.getText().toString().trim();
            intent.putExtra("phone_number", phone);
            startActivity(intent);
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (pendingPhoneToCall != null && !pendingPhoneToCall.isEmpty()) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + pendingPhoneToCall));
                    startActivity(callIntent);
                }
            } else {
                Toast.makeText(this, "Cần cấp quyền để gọi điện", Toast.LENGTH_SHORT).show();
            }
            pendingPhoneToCall = null;
        }
    }
}
