package com.example.RecipeApi.models;
import com.example.RecipeApi.models.securitymodels.CustomUserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
//import org.springframework.data.annotation.Id;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

    //@Valid (commented out prior to auth upgrade)
    //@NotNull
    //@Column(nullable = false) (commented out prior to auth upgrade)
    //private String username; // replaced by user (for authentication)

    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn
    @JsonIgnore
    private CustomUserDetails user;

    //@Valid
    @NotNull(message = "Rating cannot be null")
    //@Column(nullable = false)
    @Min(
            value = 0,
            message = "There rating value cannot be below 0!"
    )
    @Max(
            value = 10,
            message = "There rating value cannot be above 10!"
    )
    private Integer rating;

    private String description;

//    public void setRating(int rating) {
//        if (rating <= 0 || rating > 10) {
//            throw new IllegalStateException("Rating must be between 0 and 10.");
//        }
//        this.rating = rating;
//    }


    public void setRating(Integer rating) {
        //if (rating <= 0 || rating > 10) {
        //    throw new IllegalStateException("Rating must be between 0 and 10.");
       //}
        this.rating = rating;
    }

    public void validate() throws IllegalStateException {
        if(rating==null) {
           throw new IllegalStateException("Rating cannot be null!");
       }
    }

    public String getAuthor() {
        return user.getUsername();
    }

}
