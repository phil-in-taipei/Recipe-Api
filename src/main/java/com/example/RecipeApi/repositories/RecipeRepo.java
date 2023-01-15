package com.example.RecipeApi.repositories;

import com.example.RecipeApi.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long>{
    ArrayList<Recipe> findByNameContaining(String name);
    //ArrayList<Recipe> findByUserNameContaining(String name);
    ArrayList<Recipe> findByUser_UsernameContaining(String name);

    ArrayList<Recipe> findByUser_Username(String username);

}
