package com.ind.lms.restcontroller;


import com.ind.lms.models.Ingredient;
import com.ind.lms.models.Taco;
import com.ind.lms.models.TacoOrder;
import com.ind.lms.repository.interfaces.IngredientRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
@SessionAttributes("tacoOrder")
@RequestMapping("/design")
@RequiredArgsConstructor
public class DesignTacoController {

    @Autowired
    private final IngredientRepository ingredientRepository;

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    private Iterable<Ingredient> filterByType(
            Iterable<Ingredient> ingredients, Ingredient.Type type) {
        return StreamSupport.stream(ingredients.spliterator(), false)
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder tacoOrder(){
        return new TacoOrder();
    }
    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String home() {
        log.info("Inside: home");
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco, Errors error, @ModelAttribute TacoOrder tacoOrder ){

        if (error.hasErrors())
            return "design";

        tacoOrder.addTaco(taco);
        log.info("Taco - {}",taco);
        return "redirect:/orders/current";
    }
}
