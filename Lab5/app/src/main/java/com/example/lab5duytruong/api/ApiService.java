package com.example.lab5duytruong.api;
import com.example.lab5duytruong.models.ApiResponse;
import com.example.lab5duytruong.models.LoginRequest;
import com.example.lab5duytruong.models.RegisterRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface ApiService {

    @POST("register.php")
    Call<ApiResponse> register(@Body RegisterRequest registerRequest);
    @POST("login.php")
    Call<ApiResponse> login(@Body LoginRequest loginRequest);
}

