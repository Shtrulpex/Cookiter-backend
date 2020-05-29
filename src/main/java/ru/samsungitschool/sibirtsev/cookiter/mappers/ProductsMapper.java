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
        String ar = rs.getArray("recipes").toString();

        ar=ar.substring(1,ar.length()-1);
        String[] a = ar.split(",");
        Integer[] array = new Integer[a.length];
        for(int i=0;i<a.length;i++){
            array[i]=Integer.parseInt(a[i]);
        }
        pr.setRecipes(array);

        return pr;
    }
}
