package ru.samsungitschool.sibirtsev.cookiter.entity;

public class Products {

    private Integer id;
    private String name;
    private Integer[] recipes;

    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRecipes(Integer[] recipes) {
        this.recipes = recipes;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Integer[] getRecipes() {
        return recipes;
    }
}
