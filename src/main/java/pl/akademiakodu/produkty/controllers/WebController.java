package pl.akademiakodu.produkty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.akademiakodu.produkty.models.ProductForm;
import pl.akademiakodu.produkty.repository.CategoryRepository;
import pl.akademiakodu.produkty.services.ProductListService;
import pl.akademiakodu.produkty.services.ProductSearchService;

import javax.validation.Valid;


@Controller
public class WebController{


    @Autowired
    ProductListService productListService;
    @Autowired
    ProductSearchService productSearchService;


    @GetMapping("/")
    public String showForm(ProductForm productForm) {
        return "form";
    }

    @PostMapping("/")
    public String checkProductInfo(@ModelAttribute @Valid ProductForm productForm,
                                   BindingResult bindingResult, Model model,
                                   @RequestParam("choice") String choice) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        model.addAttribute("product", productForm);
        productListService.addProductToList(productForm);
        productSearchService.addProductToList(productForm);

        if (choice.equals("agd")) {
            productForm.setCategoryName(CategoryRepository.getCategories().get(0).getCategoryName());
        } else if (choice.equals("rtv")) {
            productForm.setCategoryName(CategoryRepository.getCategories().get(1).getCategoryName());
        } else if (choice.equals("others")) {
            productForm.setCategoryName(CategoryRepository.getCategories().get(2).getCategoryName());
        }
        return "result";
    }

    @GetMapping("/results")
    public String index(Model model){
        model.addAttribute("products", ProductListService.getProductFromList());
        return "results";
    }

    @PostMapping("/results")
    public String search (@RequestParam("search") String search,
                          Model model){
            model.addAttribute("field1",search);
            model.addAttribute("searchResults", ProductSearchService.search(search, ProductSearchService.getProductFromList()));

        return "searchResults";
    }

    @PostMapping("/resultsByCategory")
    public String searchByCategory (@RequestParam("searchCategory") String searchCategory,
                          Model model){
        model.addAttribute("field2",searchCategory);
        model.addAttribute("searchResults2", ProductSearchService.searchByCategory(searchCategory, ProductSearchService.getProductFromList()));

        return "searchResults";
    }

    @GetMapping("/categories")
    public String showCategories (CategoryRepository categoryRepository, Model model) {
        model.addAttribute("categories",CategoryRepository.getCategories());
        return "categories";
    }


/* REDIRECT VERISION
    @PostMapping("/")
    public String checkProductInfo(@ModelAttribute @Valid ProductForm productForm,
                                   BindingResult bindingResult, Model model,
                                   @RequestParam("choice") String choice) {

        if (bindingResult.hasErrors()) {
            return "form";
        }
        redirectAttributes.addFlashAttribute("product",productForm);

        productListService.addProductToList(productForm);
        productSearchService.addProductToList(productForm);

        if (choice.equals("agd")) {
            productForm.setCategoryName(CategoryRepository.getCategories().get(0).getCategoryName());
        } else if (choice.equals("rtv")) {
            productForm.setCategoryName(CategoryRepository.getCategories().get(1).getCategoryName());
        } else if (choice.equals("others")) {
            productForm.setCategoryName(CategoryRepository.getCategories().get(2).getCategoryName());
        }

        return "redirect:/results"; // after session clean data  ??
    }
*/

}