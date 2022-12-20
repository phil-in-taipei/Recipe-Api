package com.example.RecipeApi.models;
import lombok.*;
//import org.springframework.data.annotation.Id;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    //@Valid
    @NotNull
    //@Column(nullable = false)
    private String username;

    @Valid
    @NotNull(message = "Rating cannot be null")
    //@Column(nullable = false)
    private Integer rating;

    private String description;

    public void setRating(int rating) {
        if (rating <= 1 || rating > 10) {
            throw new IllegalStateException("Rating must be between 0 and 10.");
        }
        this.rating = rating;
    }

   public void validate() throws IllegalStateException {
        if(rating==null) {
           throw new IllegalStateException("Must enter a rating between 0 and 10.");
       }
    }

}
