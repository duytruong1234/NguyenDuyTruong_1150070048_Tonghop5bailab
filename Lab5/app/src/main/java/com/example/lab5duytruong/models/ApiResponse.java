package com.example.lab5duytruong.models;
import com.google.gson.annotations.SerializedName;
public class ApiResponse {
    @SerializedName("success")
    private boolean success;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private User data;
    public ApiResponse() {
    }
    public ApiResponse(boolean success, String message, User data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

