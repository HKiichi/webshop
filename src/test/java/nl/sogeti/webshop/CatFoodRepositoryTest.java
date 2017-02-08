package nl.sogeti.webshop;

import nl.sogeti.webshop.model.Product;

import nl.sogeti.webshop.service.ProductService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;


 public class CatFoodRepositoryTest extends AbstractTest {

    ProductService repository;


    @Before
    public void setup(){
        repository = new ProductService();
        repository.entityManager = getEntityManager();
        getTransaction().begin();
    }

     @Test
    public void testPersist(){
        Product product = new Product();
        product.setName("sheba");
        product= repository.persist(product);

        assertNotNull(repository.find((long) product.getProductId()));
    }


    @After
    public void teardown(){
       if (getTransaction().isActive()){
           getTransaction().rollback();
       }
   }
}


