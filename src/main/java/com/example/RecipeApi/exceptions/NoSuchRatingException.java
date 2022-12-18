package com.example.RecipeApi.exceptions;

public class NoSuchRatingException extends Exception {
    public NoSuchRatingException(String message) {
        super(message);
    }
    public NoSuchRatingException() {
    }
}
