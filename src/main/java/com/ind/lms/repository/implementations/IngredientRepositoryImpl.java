package com.ind.lms.repository.implementations;

import com.ind.lms.models.Ingredient;
import com.ind.lms.repository.interfaces.IngredientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor

public class IngredientRepositoryImpl implements IngredientRepository {

    private static final Logger log = LoggerFactory.getLogger(IngredientRepositoryImpl.class.getSimpleName());

    private final JdbcTemplate jdbcTemplate ;


    @Override
    public List<Ingredient> findAll() {

        String query = "SELECT id,name,type FROM ingredient";
        RowMapper<Ingredient> ingredientRowMapper = getIngredientRowMapper();
        List<Ingredient> ingredients = null ;

        try{
                ingredients = jdbcTemplate.query(query, ingredientRowMapper);;
        }
        catch (Exception sqlException){
            log.error(sqlException.getCause().toString());
            throw sqlException;
        }
        return ingredients;
    }

    @Override
    public Optional<Ingredient> findById(String id) {

        String query = "SELECT id,name,type FROM Ingredient WHERE id=?";
        RowMapper<Ingredient> ingredientRowMapper = getIngredientRowMapper();

        List<Ingredient> ingredients = jdbcTemplate.query(query, ingredientRowMapper,id);
        return ingredients.isEmpty() ? Optional.empty() : Optional.of(ingredients.get(0));

    }

    private static RowMapper<Ingredient> getIngredientRowMapper() {
        return (resultSet, rowNum) -> Ingredient.builder()
                .id(resultSet.getString("id"))
                .name(resultSet.getString("name"))
                .type(Ingredient.Type.valueOf(resultSet.getString("type")))
                .build();
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update(
                "insert into ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }
}
