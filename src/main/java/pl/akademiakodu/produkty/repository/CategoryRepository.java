package pl.akademiakodu.produkty.repository;

import pl.akademiakodu.produkty.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    private static List<Category> categories = new ArrayList<>();

    static {
        categories.add(new Category("AGD"));
        categories.add(new Category("RTV"));
        categories.add(new Category("OTHERS"));
    }

    public static List<Category> getCategories(){
        return categories;
    }
}
