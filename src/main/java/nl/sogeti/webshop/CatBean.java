package nl.sogeti.webshop;

import nl.sogeti.webshop.Product.CatFood;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ikikuchi on 13-1-2017.
 */
@Named("catFood")
public class CatBean implements Serializable{


    @Inject
    CatFoodService catFoodService;

    @Inject
    Logger logger;


    String name= "Sheba";
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CatFood> list() {
        return catFoodService.findAll();
    }


    public String save(){
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

    public String works(){
        System.out.println("It worked");
        return "hi";
    }
    }

