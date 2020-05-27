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
import ru.samsungitschool.sibirtsev.cookiter.entity.Recipes;
import ru.samsungitschool.sibirtsev.cookiter.repositories.RecipesRepository;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping("rec")
public class RecipesController {
    @Autowired
    private RecipesRepository recipes;
    @RequestMapping(value="/create",method=RequestMethod.POST)
    public int createRecipe(@RequestBody Recipes recipes1){
        Connection con = null;
        try {
            Array products = con.createArrayOf("integer", recipes1.getProducts());
            return recipes.createRecipe(recipes1.getName(), products, recipes1.getRecipe(), recipes1.getAuthor());
        }catch(SQLException e){
            e.getLocalizedMessage();
            return 0;
        }
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public int deleteRecipe(@PathVariable Integer id){
        return recipes.deleteRecipe(id);
    }
}
