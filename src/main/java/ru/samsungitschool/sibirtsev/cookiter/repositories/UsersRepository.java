package ru.samsungitschool.sibirtsev.cookiter.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.samsungitschool.sibirtsev.cookiter.entity.Users;
import ru.samsungitschool.sibirtsev.cookiter.mappers.UsersMapper;

@Component
public class UsersRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int creatUser(String email, String login, Integer password){
        return jdbcTemplate.update("INSERT INTO \"USERS\" (\"EMAIL\", \"LOGIN\", \"PASSWORD\") VALUES(?, ?, ?)", email, login, password);
    }
    public int updateUser(Users users){
        return jdbcTemplate.update("UPDATE \"USERS\" SET \"PASSWORD\" = ? WHERE \"LOGIN\" LIKE ?", users.getPassword(), users.getLogin());
    }
    public int deleteUser(Integer id){
        return jdbcTemplate.update("DELETE FROM \"USERS\" WHERE \"ID\" = ?", id);
    }

    public Users getRegisterAccess(String login){
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM \"USERS\" WHERE \"LOGIN\" LIKE  ? ", new UsersMapper(), login);
        }catch (Exception e){
            return null;
        }
    }
    public boolean getUserAccessbyLog(String login, Integer pass){
        try {
            Users user = jdbcTemplate.queryForObject("SELECT * FROM \"USERS\" WHERE \"LOGIN\" LIKE  ? ", new UsersMapper(), login);
            return user.getPassword().equals(pass);
        }catch (Exception e){
            e.getLocalizedMessage();
            return false;
        }
    }
    public boolean getUserAccessbyEmail(String email, Integer pass){
        try {
            Users user = jdbcTemplate.queryForObject("SELECT * FROM \"USERS\" WHERE \"EMAIL\" LIKE  ? ", new UsersMapper(), email);
            return user.getPassword().equals(pass);
        }catch (Exception e){
            e.getLocalizedMessage();
            return false;
        }
    }
}
