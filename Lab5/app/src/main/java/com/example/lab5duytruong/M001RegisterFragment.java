package com.example.lab5duytruong;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab5duytruong.api.ApiClient;
import com.example.lab5duytruong.api.ApiService;
import com.example.lab5duytruong.models.ApiResponse;
import com.example.lab5duytruong.models.RegisterRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class M001RegisterFragment extends Fragment {

    private EditText edtEmail, edtPassword, edtConfirmPassword;
    private Button btnRegister;
    private ImageView btnBack;
    private ApiService apiService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        apiService = ApiClient.getApiService();

        edtEmail = view.findViewById(R.id.edtEmail);
        edtPassword = view.findViewById(R.id.edtPassword);
        edtConfirmPassword = view.findViewById(R.id.edtConfirmPassword);
        btnRegister = view.findViewById(R.id.btnRegister);
        btnBack = view.findViewById(R.id.btnBack);

        btnRegister.setOnClickListener(v -> handleRegister());

        btnBack.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).navigateToLogin();
            }
        });

        return view;
    }

    private void handleRegister() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        String confirmPassword = edtConfirmPassword.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(getContext(), "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty()) {
            Toast.makeText(getContext(), "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (confirmPassword.isEmpty()) {
            Toast.makeText(getContext(), "Please confirm password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(getContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(getContext(), "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
            return;
        }

        btnRegister.setEnabled(false);
        btnRegister.setText("Registering...");

        RegisterRequest registerRequest = new RegisterRequest(email, password, null);

        Call<ApiResponse> call = apiService.register(registerRequest);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                btnRegister.setEnabled(true);
                btnRegister.setText("Register");

                if (response.isSuccessful() && response.body() != null) {
                    ApiResponse apiResponse = response.body();

                    if (apiResponse.isSuccess()) {
                        Toast.makeText(getContext(), apiResponse.getMessage(), Toast.LENGTH_SHORT).show();

                        edtEmail.setText("");
                        edtPassword.setText("");
                        edtConfirmPassword.setText("");

                        if (getActivity() instanceof MainActivity) {
                            ((MainActivity) getActivity()).navigateToLogin();
                        }
                    } else {
                        Toast.makeText(getContext(), apiResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Registration failed. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                btnRegister.setEnabled(true);
                btnRegister.setText("Register");

                Toast.makeText(getContext(), "Network error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

