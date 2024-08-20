package com.ind.lms.repository.interfaces;

import com.ind.lms.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface IngredientRepository extends JpaRepository<Ingredient, String> {
    /*List<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);*/
}
