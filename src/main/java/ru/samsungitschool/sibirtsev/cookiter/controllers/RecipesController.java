package ru.samsungitschool.sibirtsev.cookiter.controllers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.samsungitschool.sibirtsev.cookiter.TrueFalseModel;
import ru.samsungitschool.sibirtsev.cookiter.entity.Recipes;
import ru.samsungitschool.sibirtsev.cookiter.repositories.RecipesRepository;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.List;

@RestController
@RequestMapping("rec")
public class RecipesController {
    @Autowired
    private RecipesRepository recipes;

    @RequestMapping(value="/create",method=RequestMethod.POST)
    public Recipes createRecipe(@RequestBody Recipes recipes1){

        return recipes.createRecipe(recipes1.getName(), recipes1.getProducts(), recipes1.getRecipe(), recipes1.getAuthor());
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public int deleteRecipe(@PathVariable Integer id){
        return recipes.deleteRecipe(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Recipes> getAll(){
        return recipes.getAll();
    }
}
