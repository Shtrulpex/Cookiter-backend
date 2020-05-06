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
import ru.samsungitschool.sibirtsev.cookiter.entity.Products;

@Component
public class ProductsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createProduct(String name){
        return jdbcTemplate.update("INSERT INTO \"PRODUCTS\" (\"NAME\") VALUES (?)", name);
    }

    public int updateProduct(Products products){
        return jdbcTemplate.update("UPDATE \"PRODUCTS\" SET \"RECIPES\" = ? WHERE \"ID\" = ?", products.getRecipes(), products.getId());
    }

    public int deleteProduct(Integer id){
        return jdbcTemplate.update("DELETE FROM \"PRODUCTS\" WHERE \"ID\" = ?", id);
    }
}
