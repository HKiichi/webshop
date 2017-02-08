package nl.sogeti.webshop.controller;

import nl.sogeti.webshop.model.Customer;
import nl.sogeti.webshop.model.UserAccount;
import nl.sogeti.webshop.service.CustomerService;
import nl.sogeti.webshop.service.UserAccountService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by ikikuchi on 6-2-2017.
 */
@Named
@RequestScoped
public class AccountBean implements Serializable {

    @Inject
    Customer customer;

    @Inject
    UserAccount userAccount;

    @Inject
    CustomerService customerService;

    @Inject
    UserAccountService userAccountService;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String saveAccount() {
        if (customer.getVoornaam() != null) {
            customerService.persist(customer);
            userAccount.setCustomer(customer);

            userAccountService.persist(userAccount);

        }
        return "index";
    }

}
