package nl.sogeti.webshop.model;

import javax.persistence.*;

/**
 * Created by ikikuchi on 6-2-2017.
 */
@Entity
public class UserAccount {

    @Id
    @GeneratedValue
    private int userAccountId;
    private String password;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
