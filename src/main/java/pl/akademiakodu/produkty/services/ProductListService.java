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

public class ProductListService {
    
    private static List<ProductForm> productFormList;

    public ProductListService() {
        productFormList = new ArrayList<>();
    }

    public void addProductToList (ProductForm form){
        productFormList.add(form);
    }

    public static List<ProductForm> getProductFromList() {
        return productFormList;
    }

}
