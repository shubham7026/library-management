package com.ind.lms.restcontroller;


import com.ind.lms.models.Ingredient;
import com.ind.lms.models.Taco;
import com.ind.lms.models.TacoOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@SessionAttributes("tacoOrder")
public class HomeController {


    //adding empty taco to model
    @ModelAttribute(name = "taco")
    public Taco taco(){
        return Taco.builder().build();
    }


    @ModelAttribute(name = "tacoOrder")
    public TacoOrder tacoOrder(){
        return TacoOrder.builder().build();
    }

    @ModelAttribute
    public void addIngredientToModel(Model model){
        List<Ingredient> ingredientList = Arrays.asList(
                Ingredient.builder().name("Mix-Veg").id("1").type(Ingredient.Type.VEGGIES).build(),
                Ingredient.builder().name("Mix-Veg with Chicken").id("1").type(Ingredient.Type.VEGGIES).build(),
                Ingredient.builder().name("Paneer").id("1").type(Ingredient.Type.WRAP).build(),
                Ingredient.builder().name("Regular").id("1").type(Ingredient.Type.CHEESE).build(),
                Ingredient.builder().name("Extra Mold").id("1").type(Ingredient.Type.CHEESE).build(),
                Ingredient.builder().name("Chicken").id("1").type(Ingredient.Type.WRAP).build(),
                Ingredient.builder().name("Green").id("1").type(Ingredient.Type.SAUCE).build(),
                Ingredient.builder().name("Red").id("1").type(Ingredient.Type.SAUCE).build()
        );

        Ingredient.Type[] types = Ingredient.Type.values();
        for(Ingredient.Type type : types){
            model.addAttribute( type.name().toLowerCase(), filterType(ingredientList,type));
        }
    }

    private List<Ingredient> filterType(List<Ingredient> ingredientList, Ingredient.Type type) {
        return ingredientList.stream()
                .filter(ingredient -> ingredient.getType().equals(type)).collect(Collectors.toList());
    }


    @GetMapping("/")
    public String home() {

        return "home";
    }
}
