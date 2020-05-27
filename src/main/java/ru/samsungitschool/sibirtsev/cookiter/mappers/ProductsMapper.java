package ru.samsungitschool.sibirtsev.cookiter.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.samsungitschool.sibirtsev.cookiter.entity.Products;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductsMapper implements RowMapper<Products> {
    public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
        Products pr = new Products();
        pr.setName(rs.getString("name"));
        pr.setId(rs.getInt("id"));
       // Array ar = rs.getArray("recipes");
        //Integer[] recipes = (Integer[])ar.getArray();
        //pr.setRecipes(recipes);
        return pr;
    }
}
