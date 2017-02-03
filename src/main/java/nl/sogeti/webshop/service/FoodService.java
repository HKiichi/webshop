package nl.sogeti.webshop.service;

import nl.sogeti.webshop.model.Food;

import javax.ejb.Stateless;

/**
 * Created by ikikuchi on 13-1-2017.
 */
@Stateless
public class FoodService extends AbstractCrudRepository<Food> {


    @Override
    protected Class<Food> getEntityClass(){
        return Food.class;

    }
}
