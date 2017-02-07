package nl.sogeti.webshop.service;

import nl.sogeti.webshop.model.Order;

import javax.ejb.Stateless;

/**
 * Created by ikikuchi on 1-2-2017.
 */
@Stateless
public class OrderService extends AbstractCrudRepository<Order>{

        @Override
        protected Class<Order> getEntityClass(){
            return Order.class;

        }
    }

