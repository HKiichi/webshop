package nl.sogeti.webshop.service;

import nl.sogeti.webshop.model.Customer;

import javax.ejb.Stateless;

/**
 * Created by ikikuchi on 31-1-2017.
 */
@Stateless
public class CustomerService extends AbstractCrudRepository<Customer> {

    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;

    }
}
