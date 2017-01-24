package nl.sogeti.webshop;

import nl.sogeti.webshop.Product.CatFood;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by ikikuchi on 24-1-2017.
 */
public class ShoppingCart {

    ArrayList <CatFood> list = new ArrayList<CatFood>();

    CatFood catFood;
     double price;

    public void addProduct(){
    list.add(new CatFood());
    }

    public double calculatePrice(){
        for (CatFood food : list ){
            double total = food.getPrice();

        }

        return price;

    }



}
