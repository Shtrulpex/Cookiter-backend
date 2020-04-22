package ru.samsungitschool.sibirtsev.cookiter.entity;

public class Products {

    private Integer id;
    private String name;
    private Long[] recipes;

    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRecipes(Long[] recipes) {
        this.recipes = recipes;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Long[] getRecipes() {
        return recipes;
    }
}
