package nl.sogeti.webshop.controller;

import nl.sogeti.webshop.model.Food;
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
public class FoodBean implements Serializable{


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

    public List<Food> getAllFoods() {

        return foodService.findAll();
    }


    public String saveFoodItem(){
        if (name != null) {
            Food food = new Food();
            food.setName(this.name);
            food.setDescription(this.description);
            foodService.persist(food);
            logger.log(Level.INFO, "Food " + food.getName() + " saved.");


        }

        return "hello";
    }

/*    public Boolean saveFoodItems(List<Food> products) {
        boolean saveSucceed = false;

        if(!products.isEmpty()) {
            for (Food f : products) {
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

