package com.example.lab2duytruong;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail, etPassword;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast, null);
            TextView tvMessage = layout.findViewById(R.id.tvToastMessage);
            tvMessage.setText("Bạn đã đăng nhập thành công với email: " + email + " và mật khẩu: " + password);
            Toast toast = new Toast(getApplicationContext());
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        });
    }
}
