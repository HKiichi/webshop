package nl.sogeti.webshop.controller;

import nl.sogeti.webshop.model.Product;
import nl.sogeti.webshop.service.ProductService;
import nl.sogeti.webshop.common.Parameters;

import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ikikuchi on 13-1-2017.
 */
@Named
public class ProductBean implements Serializable {


    @Inject
    ProductService productService;

    Logger logger;


    private String name;
    private String description;


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

    public List<Product> getAllFoods() {

        return productService.findAll();
    }


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


}

