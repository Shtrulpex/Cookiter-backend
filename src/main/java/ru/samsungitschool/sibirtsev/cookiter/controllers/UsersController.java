package ru.samsungitschool.sibirtsev.cookiter.controllers;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.samsungitschool.sibirtsev.cookiter.entity.Users;
import ru.samsungitschool.sibirtsev.cookiter.repositories.UsersRepository;

@RestController
@RequestMapping("user")
public class UsersController {
    @Autowired
    private UsersRepository user;

    @RequestMapping("/")
    public String index() {
        return "Hello!";
    }

    @RequestMapping(value="/create", method=RequestMethod.POST, consumes="text/plain")

    public int createUser(@RequestBody String param){
        String login;
        String email;
        Integer password;
        try{
            JSONObject json = new JSONObject(param);
            login = json.getString("login");
            email = json.getString("email");
            password = json.getInt("password");
        }catch(JSONException e){
            e.getLocalizedMessage();
            return 0;
        }
        return user.creatUser(email, login, password);
    }
    @RequestMapping(value="/update",method=RequestMethod.PUT,consumes="text/plain")
    public int updateUser(@RequestBody String param){
        Users us = new Users();
        try{
            JSONObject json = new JSONObject(param);
            us.setEmail(json.getString("email"));
            us.setId(json.getInt("id"));
            us.setLogin(json.getString("login"));
            us.setPassword(json.getInt("password"));
        }catch(JSONException e){
            e.getLocalizedMessage();
            return 0;
        }
        return user.updateUser(us);
    }
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public int deleteUser(@PathVariable Integer id){
        return user.deleteUser(id);
    }

    @RequestMapping(value="/getUserAccessbyLog", method=RequestMethod.GET, consumes="text/plain")
    public boolean getUser(@RequestBody String param){
        String login;
        Integer password;
        try {
            JSONObject json = new JSONObject(param);
            login = json.getString("login");
            password = json.getInt("password");
        }catch(JSONException e){
            e.getLocalizedMessage();
            return false;
        }
        return user.getUserAccessbyLog(login, password);
    }
    @RequestMapping(value = "/getRegisterAccess", method=RequestMethod.GET, consumes="text/plain")
    public boolean getRegisterAccess(@RequestBody String param){
        String login;
        try {
            JSONObject json = new JSONObject(param);
            login = json.getString("login");
        }catch (JSONException e){
            e.getLocalizedMessage();
            return false;
        }
        if (user.getRegisterAccess(login)==null){
            return true;
        }else return false;
    }
}
