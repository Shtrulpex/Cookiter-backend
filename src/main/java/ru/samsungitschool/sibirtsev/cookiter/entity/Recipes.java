package ru.samsungitschool.sibirtsev.cookiter.entity;

public class Recipes {


    private Integer id;
    private String name;
    private Long[] products;
    private String recipe;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(Long[] products) {
        this.products = products;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long[] getProducts() {
        return products;
    }

    public String getRecipe() {
        return recipe;
    }
}
