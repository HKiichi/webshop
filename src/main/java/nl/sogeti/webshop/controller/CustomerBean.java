package nl.sogeti.webshop.controller;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by ikikuchi on 30-1-2017.
 */
@Named
@SessionScoped
public class CustomerBean implements Serializable {
    String voornaam;
    String achternaam;

   /* @Inject
    CustomerService customerService;*/

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
        System.out.println("voornaam: " + this.voornaam);
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

   /* public String savePerson(){
        if (voornaam != null) {
            Customer person = new Customer();
            person.setVoornaam(this.voornaam);
            person.setAchternaam(this.achternaam);
            customerService.persist(person);
            //logger.log(Level.INFO, "Product " + person.getName() + " saved.");


        }

        return "index";
    }*/
}
