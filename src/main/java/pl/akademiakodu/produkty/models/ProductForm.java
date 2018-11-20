package pl.akademiakodu.produkty.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ProductForm {

    @NotNull
    @Size(min=5, max=30,message = "Nazwa musi mieć minimum 5 maksimum 30 znaków")
    private String name;

    @NotNull
    @Size(min = 5,max=50,message = "Opis musi mieć minimum 5 maksimum 50 znaków")
    private String description;
    private String categoryName;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo(){
        return "Takiego produktu nie ma";
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ProductForm{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
