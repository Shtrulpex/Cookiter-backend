package ru.samsungitschool.sibirtsev.cookiter.repositories;

import java.sql.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.samsungitschool.sibirtsev.cookiter.entity.Recipes;
import ru.samsungitschool.sibirtsev.cookiter.mappers.RecipesMapper;

@Component
public class RecipesRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createRecipe(String name, Integer[] products, String recipe, String author){
        String sql_stmt = "INSERT INTO \"RECIPES\" (\"NAME\", \"RECIPE\",\"PRODUCTS\" , \"AUTHOR\") VALUES (?, ?, \'{";

        for(int i=0; i<products.length-1;i++){
            sql_stmt+=products[i].toString()+", ";
        }
        sql_stmt+=products[products.length-1]+"}\', ?)";

         int a=jdbcTemplate.update(sql_stmt, name, recipe, author);
         return (jdbcTemplate.queryForObject("SELECT * FROM \"RECIPES\" WHERE \"NAME\" LIKE  ? ", new RecipesMapper(), name)).getId();
    }

    public int deleteRecipe(Integer id){
        return jdbcTemplate.update("DELETE FROM \"RECIPES\" WHERE \"ID\" = ?",id);
    }
}
