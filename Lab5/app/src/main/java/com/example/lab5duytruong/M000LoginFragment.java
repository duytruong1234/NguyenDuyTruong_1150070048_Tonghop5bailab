package com.example.lab5duytruong;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab5duytruong.api.ApiClient;
import com.example.lab5duytruong.api.ApiService;
import com.example.lab5duytruong.models.ApiResponse;
import com.example.lab5duytruong.models.LoginRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class M000LoginFragment extends Fragment {

    private EditText edtEmail, edtPassword;
    private Button btnLogin;
    private TextView tvForgotPassword, tvRegister;
    private ApiService apiService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        apiService = ApiClient.getApiService();

        edtEmail = view.findViewById(R.id.edtEmail);
        edtPassword = view.findViewById(R.id.edtPassword);
        btnLogin = view.findViewById(R.id.btnLogin);
        tvForgotPassword = view.findViewById(R.id.tvForgotPassword);
        tvRegister = view.findViewById(R.id.tvRegister);

        btnLogin.setOnClickListener(v -> handleLogin());

        tvRegister.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).navigateToRegister();
            }
        });

        return view;
    }

    private void handleLogin() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(getContext(), "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty()) {
            Toast.makeText(getContext(), "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        btnLogin.setEnabled(false);
        btnLogin.setText("Logging in...");
        LoginRequest loginRequest = new LoginRequest(email, password);
        Call<ApiResponse> call = apiService.login(loginRequest);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                btnLogin.setEnabled(true);
                btnLogin.setText("Login");

                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse apiResponse = response.body();

                    if (apiResponse.isSuccess()) {
                        Toast.makeText(getContext(), apiResponse.getMessage(), Toast.LENGTH_SHORT).show();

                        if (apiResponse.getData() != null) {
                            SharedPreferences prefs = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putInt("user_id", apiResponse.getData().getId());
                            editor.putString("email", apiResponse.getData().getEmail());
                            editor.putString("full_name", apiResponse.getData().getFullName());
                            editor.putBoolean("is_logged_in", true);
                            editor.apply();
                        }

                        edtEmail.setText("");
                        edtPassword.setText("");

                    } else {
                        Toast.makeText(getContext(), apiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Login failed. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                btnLogin.setEnabled(true);
                btnLogin.setText("Login");

                Toast.makeText(getContext(), "Network error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
