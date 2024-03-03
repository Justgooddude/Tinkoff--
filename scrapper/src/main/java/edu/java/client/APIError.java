package edu.java.client;

public class APIError extends RuntimeException {
    public APIError(String message, int statusCode) {
        super(message + " with status code: " + statusCode);
    }
}
