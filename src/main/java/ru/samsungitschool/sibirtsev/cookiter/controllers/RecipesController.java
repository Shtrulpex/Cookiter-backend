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

@RestController
@RequestMapping("rec")
public class RecipesController {
    @Autowired
    private RecipesRepository recipes;
    @RequestMapping(value="/recipe/create",method=RequestMethod.PUT,consumes="text/plain")
    public int createRecipe(@RequestBody String param){
        String name, recipe;
        Long[] products;
        JSONArray jsonar;
        try{
            JSONObject json = new JSONObject(param);
            name = json.getString("name");
            recipe = json.getString("recipe");
            jsonar = json.getJSONArray("products");
            products = new Long[jsonar.length()];
            for(int i=0; i<jsonar.length();i++){
                products[i] = jsonar.getLong(i);
            }
        }catch(JSONException e){
            e.getLocalizedMessage();
            return 0;
        }
        return recipes.createRecipe(name, products, recipe);
    }
    @RequestMapping(value="/recipe/update",method=RequestMethod.POST,consumes="text/plain")
    public int updatePhoneNumber(@RequestBody String param){
        Recipes rec = new Recipes();
        try {
            JSONObject json = new JSONObject(param);
            Long[] products;
            JSONArray jsonar;
            rec.setId(json.getInt("id"));
            rec.setName(json.getString("name"));
            jsonar = json.getJSONArray("products");

            products = new Long[jsonar.length()];
            for(int i=0; i<jsonar.length();i++){
                products[i] = jsonar.getLong(i);
            }

            rec.setProducts(products);
        }catch(JSONException e){
            e.getLocalizedMessage();
            return 0;
        }
        return recipes.updateRecipe(rec);
    }
    @RequestMapping(value="/recipe/{id}", method=RequestMethod.DELETE)
    public int deleteRecipe(@PathVariable Integer id){
        return recipes.deleteRecipe(id);
    }
}
