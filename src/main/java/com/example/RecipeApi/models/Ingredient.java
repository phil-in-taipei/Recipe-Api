package com.example.RecipeApi.models;

import lombok.Getter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
public class Ingredient {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String amount;

    private String state;
}
