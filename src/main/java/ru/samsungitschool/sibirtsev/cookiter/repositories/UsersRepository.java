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
import ru.samsungitschool.sibirtsev.cookiter.entity.Users;

@Component
public class UsersRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int creatUser(String email, String login, Integer password){
        return jdbcTemplate.update("INSERT INTO \"USERS\" (\"EMAIL\", \"LOGIN\", \"PASSWORD\") VALUES(?, ?, ?)", email, login, password);
    }
    public int updateUser(Users users){
        return jdbcTemplate.update("UPDATE \"USERS\" SET \"PASSWORD\" = ? WHERE \"ID\" = ?", users.getPassword(), users.getId());
    }
    public int deleteUser(Integer id){
        return jdbcTemplate.update("DELETE FROM \"USERS\" WHERE \"ID\" = ?", id);
    }
    public Users getUserbyLogin(String login){
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM \"USERS\" WHERE \"LOGIN\" =?", new UsersMapper(), login);
        }catch (Exception e){
            return null;
        }
    }
    public boolean getUserAccess(String login, Integer pass){
        Users user = jdbcTemplate.queryForObject("SELECT * FROM \"USERS\" WHERE \"LOGIN\" =?", new UsersMapper(), login);
        return user.getPassword()==pass;
    }
}
