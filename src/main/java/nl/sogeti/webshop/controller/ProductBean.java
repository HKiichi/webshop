package nl.sogeti.webshop.controller;

import nl.sogeti.webshop.model.Product;
import nl.sogeti.webshop.service.FoodService;
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
public class ProductBean implements Serializable{


    @Inject
    FoodService foodService;

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

        return foodService.findAll();
    }


    public String saveFoodItem(){
        if (name != null) {
            Product product = new Product();
            product.setName(this.name);
            product.setDescription(this.description);
            foodService.persist(product);
            logger.log(Level.INFO, "Product " + product.getName() + " saved.");


        }

        return "hello";
    }

/*    public Boolean saveFoodItems(List<Product> products) {
        boolean saveSucceed = false;

        if(!products.isEmpty()) {
            for (Product f : products) {
                foodService.persist(f);
            }
            saveSucceed = true; // uitzoeken wanneer je bij de laatste bent en alle perssist heeft gewerkt
        }

        return saveSucceed;
    }*/

    public String getTestParameter(){

        return Parameters.TEST.getValue();
    }


}

