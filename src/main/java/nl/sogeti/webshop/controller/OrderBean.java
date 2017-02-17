package nl.sogeti.webshop.controller;

import nl.sogeti.webshop.model.Customer;
import nl.sogeti.webshop.model.Order;
import nl.sogeti.webshop.service.CustomerService;
import nl.sogeti.webshop.service.OrderService;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by ikikuchi on 1-2-2017.
 */
@Named
@RequestScoped
public class OrderBean {

    @Inject
    private Order order;

    @Inject
    private Customer customer;

    @Inject
    ShoppingCartBean shoppingCartBean;

    @Inject
    CustomerService customerService;

    @Inject
    private OrderService orderService;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public String saveOrder() {

        if (customer.getVoornaam() != null) {
            customerService.persist(customer);
            order.setCustomer(customer);

            order.setProductList(shoppingCartBean.getList());
            orderService.persist(order);
            shoppingCartBean.emptyCart();
            showConfirmation();
        }


        return "index";

    }


    private void showConfirmation() {
       // String message = "Bestelling gelukt";
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bedankt voor uw bestelling",null));
    }


}

