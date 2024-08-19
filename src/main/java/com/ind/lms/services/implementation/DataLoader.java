package com.ind.lms.services.implementation;

import com.ind.lms.models.Ingredient;
import com.ind.lms.repository.interfaces.IUserRepository;
import com.ind.lms.repository.interfaces.IngredientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.InjectService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@AllArgsConstructor
@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final IUserRepository iUserRepository;
    private final IngredientRepository ingredientRepository;

    @Override
    public void run(String... args) throws Exception {
        iUserRepository.findAll().forEach(user ->
                log.debug("User - {}", user)
        );

        if (ingredientRepository.findById("FLTO").isEmpty()) {
            Arrays.asList(
                    new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                    new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                    new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                    new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                    new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                    new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                    new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                    new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                    new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                    new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
            ).forEach(ingredientRepository::save);
        }


    }
}
