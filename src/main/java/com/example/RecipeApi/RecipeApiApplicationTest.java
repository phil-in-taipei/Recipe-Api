package com.example.RecipeApi;
import com.example.RecipeApi.models.*;
import com.example.RecipeApi.models.securitymodels.CustomUserDetails;
import com.example.RecipeApi.models.securitymodels.Role;
import com.example.RecipeApi.repositories.RecipeRepo;
import com.example.RecipeApi.repositories.ReviewRepo;
import com.example.RecipeApi.repositories.UserRepo;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;

        /*
@SpringBootApplication
@Profile("test")
public class RecipeApiApplicationTest implements CommandLineRunner {

    @Autowired
    RecipeRepo recipeRepo;

    @Autowired
    ReviewRepo reviewRepo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepo userRepo;

   // @Override
    // @Transactional
    //public void run(String... args) throws Exception {
        System.out.println("STARTING WITH TEST DATABASE SETUP");

        UserMeta userMeta = UserMeta.builder().name("test user").email("email@email.com").build();
        CustomUserDetails userDetails
                = new CustomUserDetails("USER",
                encoder.encode("user"),
                Collections.singletonList(new Role(Role.Roles.ROLE_USER)),
                userMeta);

        userRepo.save(userDetails);

        Ingredient ingredient = Ingredient.builder().name("flour").state("dry").amount("2 cups").build();
        Step step1 = Step.builder().description("put flour in bowl").stepNumber(1).build();
        Step step2 = Step.builder().description("eat it?").stepNumber(2).build();

        Review review = Review.builder().description("tasted very bad").rating(2).user(userDetails).build();

        Recipe recipe1 = Recipe.builder()
                .name("test recipe")
                .difficultyRating(10)
                .user(userDetails)
                .minutesToMake(2)
                .ingredients(Set.of(ingredient))
                .steps(Set.of(step1, step2))
                .reviews(Set.of(review))
                .build();


        recipeRepo.save(recipe1);
        //review.setRecipe(recipe1);
        //reviewRepo.save(review);

        UserMeta userMeta2 = UserMeta.builder().name("test user 2").email("email2@email.com").build();
        CustomUserDetails userDetails2
                = new CustomUserDetails("USER2",
                encoder.encode("user2"),
                Arrays.asList(
                        new Role(Role.Roles.ROLE_USER),
                        new Role(Role.Roles.ROLE_ADMIN)),
                userMeta2);

        userRepo.save(userDetails2);
        Review review2 = Review.builder().description("this stuff is so good").rating(10).user(userDetails).build();
        Recipe recipe2 =  Recipe.builder()
                .name("chocolate and potato chips")
                .difficultyRating(10)
                .minutesToMake(1)
                .user(userDetails2)
                .ingredients(Set.of(
                        Ingredient.builder().name("potato chips").amount("1 bag").build(),
                        Ingredient.builder().name("chocolate").amount("1 bar").build()))
                .steps(Set.of(
                        Step.builder().stepNumber(1).description("eat both items together").build()))
                .reviews(Set.of(review2))
                .build();

        recipeRepo.save(recipe2);
        //reviewRepo.save(Review.builder().user(userDetails2).recipe(recipe2).rating(10).description("this stuff is so good").build());
    }

} */

    /*
@SpringBootApplication
@Profile("test")
@Builder
public class RecipeApiApplicationTest implements CommandLineRunner {

    @Autowired
    RecipeRepo recipeRepo;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("STARTING WITH TEST DATABASE SETUP");
        if (recipeRepo.findAll().isEmpty()) {
            Ingredient ingredient = Ingredient.builder().name("flour").state("dry").amount("2 cups").build();
            Step step1 = Step.builder().description("put flour in bowl").stepNumber(1).build();
            Step step2 = Step.builder().description("eat it?").stepNumber(2).build();

            Review review = Review.builder().description("tasted pretty bad").rating(2).username("idfk").build();


            Recipe recipe1 = Recipe.builder()
                    .name("test recipe")
                    .difficultyRating(10)
                    .userName("user 1")
                    .minutesToMake(2)
                    .ingredients(Set.of(ingredient))
                    .steps(Set.of(step1, step2))
                    .reviews(Set.of(review))
                    .build();

            recipeRepo.save(recipe1);

            ingredient.setId(null);
            Recipe recipe2 = Recipe.builder()
                    .steps(Set.of(Step.builder().description("test").build()))
                    .ingredients(Set.of(Ingredient.builder().name("test ing").amount("1").state("dry").build()))
                    .name("another test recipe")
                    .userName("user 2")
                    .difficultyRating(10)
                    .minutesToMake(2)
                    .build();
            recipeRepo.save(recipe2);

            Recipe recipe3 = Recipe.builder()
                    .steps(Set.of(Step.builder().description("test 2").build()))
                    .ingredients(Set.of(Ingredient.builder().name("test ing 2").amount("2").state("wet").build()))
                    .name("another another test recipe")
                    .difficultyRating(5)
                    .userName("user 3")
                    .minutesToMake(2)
                    .build();

            recipeRepo.save(recipe3);

            Recipe recipe4 = Recipe.builder()
                    .name("chocolate and potato chips")
                    .difficultyRating(10)
                    .userName("user 4")
                    .minutesToMake(1)
                    .ingredients(Set.of(
                            Ingredient.builder().name("potato chips").amount("1 bag").build(),
                            Ingredient.builder().name("chocolate").amount("1 bar").build()))
                    .steps(Set.of(
                            Step.builder().stepNumber(1).description("eat both items together").build()))
                    .reviews(Set.of(
                            Review.builder().username("ben").rating(10).description("this stuff is so good").build()
                    ))
                    .build();

            recipeRepo.save(recipe4);
            System.out.println("FINISHED TEST DATABASE SETUP");
        }
    }
}

     */
