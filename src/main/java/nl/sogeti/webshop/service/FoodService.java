package nl.sogeti.webshop.service;

import nl.sogeti.webshop.model.Product;

import javax.ejb.Stateless;

/**
 * Created by ikikuchi on 13-1-2017.
 */
@Stateless
public class FoodService extends AbstractCrudRepository<Product> {


    @Override
    protected Class<Product> getEntityClass(){
        return Product.class;

    }
}
