package ru.samsungitschool.sibirtsev.cookiter.entity;

public class Recipes {


    private Integer id;
    private String name;
    private Integer[] products;
    private String recipe;
    private String author;
    private String ar;

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getAr() {
        return ar;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(Integer[] products) {
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

    public Integer[] getProducts() {
        return products;
    }

    public String getRecipe() {
        return recipe;
    }
}
