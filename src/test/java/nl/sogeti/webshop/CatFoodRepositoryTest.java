/*
package nl.sogeti.webshop;

import nl.sogeti.webshop.Service.CatFoodService;
import nl.sogeti.webshop.product.CatFood;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

*/
/*

 public class CatFoodRepositoryTest extends AbstractTest {

    FoodService repository;


    @Before
    public void setup(){
        repository = new FoodService();
        repository.entityManager = getEntityManager();
        getTransaction().begin();
    }

    @Test
    public void testPersist(){
        Product food = new Product();
        food.setName("sheba");
        food.setDescription("Delicious food for a good price");
        food.setPrice(5.20);
        food = repository.persist(food);
       getTransaction().commit();
        assertNotNull(repository.find(food.getId()));
    }


    @After
    public void teardown(){
       if (getTransaction().isActive()){
           getTransaction().rollback();
       }
   }
}


*/
