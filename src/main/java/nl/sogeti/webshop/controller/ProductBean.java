package nl.sogeti.webshop.controller;


import nl.sogeti.webshop.model.Category;
import nl.sogeti.webshop.model.Product;
import nl.sogeti.webshop.service.ProductService;
import nl.sogeti.webshop.common.Parameters;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ikikuchi on 13-1-2017.
 */
@Named
public class ProductBean implements Serializable, ActionListener {

    @Inject
    ProductService productService;

    @Inject
    Product product;

    @Inject
    Category category;

    Logger logger;


    private String name;
    private String description;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getSelectedProducts() {

   // if(category selected){
      //  productService.getProductsByCategory()
  //  }


        return productService.findAll();

        // return list
    }

   /* public HashMap<Product, Boolean> getNewList(Product x) {

        Map<Product, Boolean> categoryMap = new HashMap<Product, Boolean>();
        for (Product p : list) {
            if (category.id == category.getCategoryId()) {

            }
        }

        productService.findAll();
        product.setCategory(category);
        if (category.id == category.getCategoryId()) {
            newList.add(x);
        }

        return newList;
    }*/


    public String saveFoodItem() {
        if (name != null) {
            Product product = new Product();
            product.setName(this.name);
            product.setDescription(this.description);
            productService.persist(product);
            logger.log(Level.INFO, "Product " + product.getName() + " saved.");


        }

        return "hello";
    }

    public String getTestParameter() {

        return Parameters.TEST.getValue();
    }


    @Override
    public void processAction(ActionEvent actionEvent) throws AbortProcessingException {
        System.out.println("button checked!");
    }
}

