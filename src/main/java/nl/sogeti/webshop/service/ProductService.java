package nl.sogeti.webshop.service;

import nl.sogeti.webshop.model.Category;
import nl.sogeti.webshop.model.Product;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by ikikuchi on 13-1-2017.
 */
@Stateless
public class ProductService extends AbstractCrudRepository<Product> {

   public List<Product> getProductsByCategory(Category category) {
        List<Product> result = entityManager.createQuery("SELECT p FROM Product p WHERE p.category = :category")
                .setParameter("category", category.getCategoryId())
                .getResultList();

        return result;
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;

    }
}
