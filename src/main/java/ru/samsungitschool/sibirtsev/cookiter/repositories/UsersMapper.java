package ru.samsungitschool.sibirtsev.cookiter.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import ru.samsungitschool.sibirtsev.cookiter.entity.Users;


public class UsersMapper implements RowMapper<Users>{
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException{
        Users user = new Users();
        user.setId(rs.getInt("id"));
        user.setPassword(rs.getInt("password"));
        user.setLogin(rs.getString("login"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}
