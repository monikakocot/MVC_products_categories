package pl.akademiakodu.produkty.services;

import org.springframework.stereotype.Service;
import pl.akademiakodu.produkty.models.ProductForm;

import java.util.ArrayList;
import java.util.List;

@Service
//@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS) // zmiana  z singletonu na zasięg seryjny
// czyli teraz Bean Service będzie tworzony od nowa dla każdej sesji.
// czyli jak wejdziemy z innej przeglądarki, innego komputera to lista alertów jest tworzona od nowa
// zastosowanie np. system logowania - stan na sesję zalogowania; koszyk  w sklepie.

public class ProductSearchService {

    private static List<ProductForm> productFormList;

    public ProductSearchService() {
        productFormList = new ArrayList<>();
    }

    public void addProductToList(ProductForm form) {
        productFormList.add(form);
    }

    public static List<ProductForm> getProductFromList() {
        return productFormList;
    }

    public static String search(String name, List<ProductForm> productFormList) {
        for (int i = 0; i <= productFormList.size() - 1; i++)
            if (productFormList.get(i).getName().equals(name)) {
                return productFormList.get(i).getName() + " jest dostępny/a w bazie";
            }
        return "Produktu nie ma w bazie";
    }

    public static List<ProductForm> searchByCategory(String categoryName, List<ProductForm> productFormList) {
         List<ProductForm> list = new ArrayList<>();

        for (int i = 0; i <= productFormList.size() - 1; i++) {
            if (productFormList.get(i).getCategoryName().equals(categoryName)) {
                list.add(productFormList.get(i));
            }
        }
        return list;

    }
}


