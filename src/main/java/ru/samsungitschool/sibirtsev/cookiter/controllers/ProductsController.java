package ru.samsungitschool.sibirtsev.cookiter.controllers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.samsungitschool.sibirtsev.cookiter.entity.Products;
import ru.samsungitschool.sibirtsev.cookiter.repositories.ProductsRepository;

import java.util.List;

@RestController
@RequestMapping("pr")
public class ProductsController {
    @Autowired
    private ProductsRepository productsRepository;

    @RequestMapping(value="/create",method=RequestMethod.POST)
    public Integer createProduct(@RequestBody String name){
        return productsRepository.createProduct(name);
    }
    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public int updateProduct(@RequestParam Integer id, @RequestParam Integer recipeId){
        return productsRepository.updateProduct(id, recipeId);
    }
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public int deleteProduct(@PathVariable Integer id){
        return productsRepository.deleteProduct(id);
    }

    @RequestMapping(value="/getAll",method=RequestMethod.GET)
    public List<Products> getAll(){
        return productsRepository.getAll();
    }
}
