package ru.samsungitschool.sibirtsev.cookiter.controllers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.samsungitschool.sibirtsev.cookiter.TrueFalseModel;
import ru.samsungitschool.sibirtsev.cookiter.entity.Recipes;
import ru.samsungitschool.sibirtsev.cookiter.repositories.RecipesRepository;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

@RestController
@RequestMapping("rec")
public class RecipesController {
    @Autowired
    private RecipesRepository recipes;

    @RequestMapping(value="/create",method=RequestMethod.POST)
    public TrueFalseModel createRecipe(@RequestBody Recipes recipes1){
        TrueFalseModel resp = new TrueFalseModel();
        resp.setResponse(recipes.createRecipe(recipes1.getName(), recipes1.getProducts(), recipes1.getRecipe(), recipes1.getAuthor()));
         return resp;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public int deleteRecipe(@PathVariable Integer id){
        return recipes.deleteRecipe(id);
    }
}
