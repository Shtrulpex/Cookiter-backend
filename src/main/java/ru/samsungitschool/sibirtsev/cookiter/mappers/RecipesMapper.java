package ru.samsungitschool.sibirtsev.cookiter.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.samsungitschool.sibirtsev.cookiter.entity.Recipes;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecipesMapper implements RowMapper<Recipes> {
    public Recipes mapRow(ResultSet rs, int rowNum) throws SQLException {
        Recipes recipe = new Recipes();
        recipe.setName(rs.getString("name"));
        recipe.setAuthor(rs.getString("author"));
        recipe.setRecipe(rs.getString("recipe"));
        recipe.setId(rs.getInt("id"));
        String ar = rs.getArray("products").toString();

        ar=ar.substring(1,ar.length()-1);
        String[] a = ar.split(",");
        Integer[] array = new Integer[a.length];
        for(int i=0;i<a.length;i++){
            array[i]=Integer.parseInt(a[i]);
        }
        recipe.setProducts(array);
        return recipe;
    }
}
