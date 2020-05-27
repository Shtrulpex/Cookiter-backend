package ru.samsungitschool.sibirtsev.cookiter.repositories;

import java.sql.*;

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

    public int createRecipe(String name, Array products, String recipe, String author){
        return jdbcTemplate.update("INSERT INTO \"RECIPES\" (\"NAME\", \"PRODUCTS\", \"RECIPE\", \"AUTHOR\") VALUES (?, ?, ?, ?)", name, products, recipe, author);
    }

    public int deleteRecipe(Integer id){
        return jdbcTemplate.update("DELETE FROM \"RECIPES\" WHERE \"ID\" = ?",id);
    }
}
