package com.example.RecipeApi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import com.example.RecipeApi.models.Recipe;
import com.example.RecipeApi.models.Review;
import com.example.RecipeApi.models.securitymodels.CustomUserDetails;
import com.example.RecipeApi.models.securitymodels.Role;
import com.example.RecipeApi.repositories.RecipeRepo;
import com.example.RecipeApi.repositories.ReviewRepo;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {
    @Autowired
    RecipeRepo recipeRepo;

    @Autowired
    ReviewRepo reviewRepo;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        //this method will not be used. But if used by accident should always block access for good measure.
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        System.out.println("Calling the 'has permission' method in custom permission evaluator");
        if (!permission.getClass().equals(String.class)) {
            throw new SecurityException("Cannot execute hasPermission() calls where permission is not in String form");
        }

        //if the user is an admin they should be allowed to proceed
        if (userIsAdmin(authentication)) {
            System.out.println("The user is authenticated -- this is inside has permission");
            return true;
        } else {
            //otherwise, the user must be the owner of the object to edit it.
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();


            if (targetType.equalsIgnoreCase("recipe")) {
                Optional<Recipe> recipe = recipeRepo.findById(Long.parseLong(targetId.toString()));
                if (recipe.isEmpty()) {
                    throw new EntityNotFoundException("The recipe you are trying to access does not exist");
                }

                //if the author of the entity matches the current user they are the owner of the recipe and should be allowed access
                System.out.println("This is the author inside the recipe object: " + recipe.get().getAuthor());
                System.out.println("This is the username inside the user details object: " + userDetails.getUsername());
                return recipe.get().getAuthor().equals(userDetails.getUsername());

            } else if (targetType.equalsIgnoreCase("review")) {
                Optional<Review> review = reviewRepo.findById(Long.parseLong(targetId.toString()));
                if (review.isEmpty()) {
                    throw new EntityNotFoundException("The review you are trying to access does not exist");
                }

                //if the author of the entity matches the current user they are the owner of the review and should be allowed access
                System.out.println("This is the author inside the review object: " + review.get().getAuthor());
                System.out.println("This is the username inside the user details object: " + userDetails.getUsername());
                return review.get().getAuthor().equals(userDetails.getUsername());
            }

        }

        return true;
    }

    public boolean userIsAdmin(Authentication authentication) {
        Collection<Role> grantedAuthorities = (Collection<Role>) authentication.getAuthorities();
        System.out.println("These are the granted authorities: " + grantedAuthorities);
        for (Role r : grantedAuthorities) {
            System.out.println("This is one of the granted authorities: " + r.getAuthority());
            if (r.getAuthority().equals("ROLE_ADMIN")) {
                return true;
            }
        }
        return false;
    }
}
