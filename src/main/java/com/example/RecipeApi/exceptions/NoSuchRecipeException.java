package com.example.RecipeApi.exceptions;

public class NoSuchRecipeException extends Exception {
    public NoSuchRecipeException(String message) {
        super(message);
    }

    public NoSuchRecipeException() {
    }
}
