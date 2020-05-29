package ru.samsungitschool.sibirtsev.cookiter.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.samsungitschool.sibirtsev.cookiter.entity.Products;
import ru.samsungitschool.sibirtsev.cookiter.mappers.ProductsMapper;

@Component
public class ProductsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createProduct(String name){
        return jdbcTemplate.update("INSERT INTO \"PRODUCTS\" (\"NAME\") VALUES (?)", name);
    }

    public int updateProduct(Integer id, Integer recipeId){

        return jdbcTemplate.update("UPDATE \"PRODUCTS\" SET \"RECIPES\" = \'{}\' WHERE 0 = 0");
    }

    public int deleteProduct(Integer id){
        return jdbcTemplate.update("DELETE FROM \"PRODUCTS\" WHERE \"ID\" = ?", id);
    }

    public List<Products> getAll(){
        return jdbcTemplate.query("SELECT * FROM \"PRODUCTS\"", new ProductsMapper());
    }
}
