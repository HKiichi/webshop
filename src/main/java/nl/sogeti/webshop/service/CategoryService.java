package nl.sogeti.webshop.service;

import nl.sogeti.webshop.model.Category;

import javax.ejb.Stateless;

/**
 * Created by ikikuchi on 8-2-2017.
 */
@Stateless
public class CategoryService extends AbstractCrudRepository {

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;

    }
}
