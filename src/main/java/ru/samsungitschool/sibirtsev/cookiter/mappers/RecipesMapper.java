package ru.samsungitschool.sibirtsev.cookiter.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.samsungitschool.sibirtsev.cookiter.entity.Recipes;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipesMapper implements RowMapper<Recipes> {
    public Recipes mapRow(ResultSet rs, int rowNum) throws SQLException {
        Recipes recipe = new Recipes();
        recipe.setName(rs.getString("name"));
        recipe.setAuthor(rs.getString("author"));
        recipe.setRecipe(rs.getString("recipe"));
        Array ar = rs.getArray("products");
        recipe.setProducts((Integer[])ar.getArray());
        return recipe;
    }
}
