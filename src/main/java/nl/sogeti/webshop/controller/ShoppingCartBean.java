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


    //Logger logger;


    public String addProduct(Product x) {
        list.add(x);
        //if(list.isEmpty()){

   /* }
    else {
        for (int i = 0; i < list.size(); i++) {
            if (x.getName() != list.get(i).getName()) {
                list.add(x);
            }
            // quantity += 1;
*/
        //}


        return "index";
    }

    public Map<Product, Integer> printInHashMap() {
        Map<Product, Integer> uniqueSet = new HashMap<Product, Integer>();

        for (Product product : list) {
            uniqueSet.computeIfAbsent(product, k -> Collections.frequency(list, product));
        }

        // logger.log(Level.INFO, String.valueOf("WAT ZIT ERIN: "+ uniqueSet.size()));

        return uniqueSet;
    }


 /*   public Set printInHashSet() {
       // int number=0;
        System.out.println("Example with Sets and Hashset");
        Set<Product> uniqueSet = new HashSet<Product>(list);

        for (Product temp : uniqueSet) {
            System.out.println(temp.getFoodId() + ": " + Collections.frequency(list, temp));
            Collections.frequency(list, temp);

        }

       return uniqueSet;
    }*/


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
        //  for(int i =0; i < list.size(); i++) {
        //    if (x.getId() == list.get(i).getId()) {
        // list.remove(i);
        // break;
        list.remove(x);
        //   break;
        //  }
        //  }
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

    /*public String getName() {
        if(!list.isEmpty())
             return list.get(list.size()-1).getName();

        return "niks";
    }*/

    /*public String getDescription(){
        return list.get(list.size()-1).getDescription();
    }

    public double getPrice(){
        return list.get(list.size()-1).getPrice();
    }*/


}
