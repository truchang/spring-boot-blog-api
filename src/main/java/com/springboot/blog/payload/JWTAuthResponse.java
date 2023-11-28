package com.springboot.blog.payload;

public class JWTAuthResponse {
    private String message;
    private String accessToken;
    private String tokenType = "Bearer";

    public JWTAuthResponse(String message) {
        this.message = message;
    }

    public JWTAuthResponse(String accessToken, String message) {
        this.accessToken = accessToken;
        this.message = message;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
