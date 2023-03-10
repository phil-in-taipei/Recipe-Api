package com.example.RecipeApi.repositories;
import com.example.RecipeApi.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface ReviewRepo extends JpaRepository<Review, Long>{

    ArrayList<Review> findByRating(Integer rating);
    //ArrayList<Review> findByUsername(String username);

    ArrayList<Review> findByUser_Username(String username);
}
