package ru.samsungitschool.sibirtsev.cookiter.controllers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.samsungitschool.sibirtsev.cookiter.entity.Products;
import ru.samsungitschool.sibirtsev.cookiter.repositories.ProductsRepository;

@RestController
@RequestMapping("pr")
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;

    @RequestMapping(value="/create",method=RequestMethod.POST)
    public String createProduct(@RequestBody String name){
        //return productsRepository.createProduct(name);
        return name;
    }
    @RequestMapping(value="/update", method=RequestMethod.PUT, consumes="text/plain")
    public int updateProduct(@RequestBody String param){
        Products pr = new Products();
        try{
            JSONObject json = new JSONObject(param);
            JSONArray jsonar;
            Long[] recipes;
            pr.setId(json.getInt("id"));
            pr.setName(json.getString("name"));
            jsonar = json.getJSONArray("recipes");
            recipes = new Long[jsonar.length()];
            for (int k=0; k<jsonar.length(); k++){
                recipes[k]=jsonar.getLong(k);
            }
            pr.setRecipes(recipes);

        }catch(JSONException e){
            e.getLocalizedMessage();
            return 0;
        }
        return productsRepository.updateProduct(pr);
    }
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public int deleteProduct(@PathVariable Integer id){
        return productsRepository.deleteProduct(id);
    }
}
