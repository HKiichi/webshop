package nl.sogeti.webshop.controller;

import nl.sogeti.webshop.model.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by ikikuchi on 24-1-2017.
 */
@Named
@SessionScoped
public class ShoppingCartBean implements Serializable {

    ArrayList<Product> list;

    public void emptyCart() {
        list.clear();
    }

    public ArrayList<Product> getList() {
        return list;
    }

    public void setList(ArrayList<Product> list) {
        this.list = list;
    }

    @PostConstruct
    public void init() {
        list = new ArrayList<Product>();
    }


    public String addProduct(Product x) {
        list.add(x);

        return "index";
    }

    public Map<Product, Integer> printInHashMap() {
        Map<Product, Integer> uniqueSet = new HashMap<Product, Integer>();

        for (Product product : list) {
            uniqueSet.computeIfAbsent(product, k -> Collections.frequency(list, product));
        }

        return uniqueSet;
    }


    public String calculatePrice() {
        double total = 0;
        for (Product product : list) {
            total += product.getPrice();
        }
        String priceProduct = convertD(total);
        return priceProduct;

    }

    private String convertD(double total) {
        String price = new DecimalFormat("#0.00").format(total);
        return price;

    }

    public String removeProduct(Product x) {
        list.remove(x);

        return "cart";
    }

    public String removeAllProducts(Product x) {
        for (int i = -1; i <= list.size(); i++) {
            list.remove(x);
        }
        return "cart";
    }

    public int getSize() {
        if (list.isEmpty()) {
            return 0;
        }
        return list.size();
    }

    public String homePage() {
        return "cart";
    }


}
