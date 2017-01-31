package nl.sogeti.webshop.controller;

import nl.sogeti.webshop.service.CatFoodService;
import nl.sogeti.webshop.common.Parameters;
import nl.sogeti.webshop.product.CatFood;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ikikuchi on 13-1-2017.
 */
@Named
public class CatBean {


    @Inject
    CatFoodService catFoodService;

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

    public List<CatFood> getAllCatFoods() {

        return catFoodService.findAll();
    }


    public String saveCatBeanItem(){
        if (name != null) {
            CatFood food = new CatFood();
            food.setName(this.name);
            food.setDescription(this.description);
            catFoodService.persist(food);
            logger.log(Level.INFO, "Food " + food.getName() + " saved.");


        }

        return "hello";
    }

    public String getTestParameter(){

        return Parameters.TEST.getValue();
    }


}

