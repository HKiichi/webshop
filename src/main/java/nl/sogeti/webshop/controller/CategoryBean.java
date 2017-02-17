package nl.sogeti.webshop.controller;

import nl.sogeti.webshop.model.Category;
import nl.sogeti.webshop.service.CategoryService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by ikikuchi on 7-2-2017.
 */

@Named
public class CategoryBean {

    private String categoryName;

    @Inject
    Category category;

    @Inject
    CategoryService categoryService;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }



    /* public List<Category> getCategory(){
        return categoryService.find(key);
    }*/

}
