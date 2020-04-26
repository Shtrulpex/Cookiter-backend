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
import ru.samsungitschool.sibirtsev.cookiter.TrueFalseModel;
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

    @RequestMapping(value="/create", method=RequestMethod.POST)

    public TrueFalseModel createUser(@RequestBody Users requestUser){
        String login;
        String email;
        Integer password;
        TrueFalseModel resp = new TrueFalseModel();

        if (user.getRegisterAccess(requestUser.getLogin())==null) {
            resp.setResponse(user.creatUser(requestUser.getEmail(), requestUser.getLogin(), requestUser.getPassword()));
            return resp;
        } else {
            resp.setResponse(0);
            return resp;
        }

    }
    @RequestMapping(value="/update",method=RequestMethod.PUT)
    public int updateUser(@RequestBody Users requestUser){
        return user.updateUser(requestUser);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public int deleteUser(@PathVariable Integer id){
        return user.deleteUser(id);
    }

    @RequestMapping(value="/getUserAccessbyLog", method=RequestMethod.GET)
    public TrueFalseModel getUserByLog(@RequestParam String login, @RequestParam int password){
        TrueFalseModel resp = new TrueFalseModel();
        if(user.getUserAccessbyLog(login, password)){
            resp.setResponse(1);
        }else resp.setResponse(0);
        return resp;
    }

    @RequestMapping(value="/getUserAccessbyEmail", method=RequestMethod.GET)
    public TrueFalseModel getUserByEmail(@RequestParam String email, @RequestParam int password){
        TrueFalseModel resp = new TrueFalseModel();
        if(user.getUserAccessbyEmail(email, password)){
            resp.setResponse(1);
        }else resp.setResponse(0);
        return resp;
    }
}

//https://cookiter.herokuapp.com/