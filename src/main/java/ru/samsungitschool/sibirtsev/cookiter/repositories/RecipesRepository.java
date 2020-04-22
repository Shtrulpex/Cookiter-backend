package ru.samsungitschool.sibirtsev.cookiter.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.samsungitschool.sibirtsev.cookiter.entity.Recipes;

@Component
public class RecipesRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createRecipe(String name, Long[] products, String recipe){
        return jdbcTemplate.update("INSERT INTO \"RECIPES\" (\"NAME\", \"PRODUCTS\", \"RECIPE\") VALUES (?, ?, ?)", name, products, recipe);
    }
    public int updateRecipe(Recipes recipes){
        return  jdbcTemplate.update("UPDATE \"RECIPES\" SET \"NAME\" = ? \"RECIPE\" = ? WHERE \"ID\"=?", recipes.getName(), recipes.getRecipe());
    }
    public int deleteRecipe(Integer id){
        return jdbcTemplate.update("DELETE FROM \"RECIPES\" WHERE \"ID\" = ?",id);
    }
}
