package nl.sogeti.webshop;

import nl.sogeti.webshop.service.CatFoodService;
import nl.sogeti.webshop.product.CatFood;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ikikuchi on 24-1-2017.
 */
@Named
@SessionScoped
public class ShoppingCart implements Serializable{

    ArrayList <CatFood> list;


    public ArrayList<CatFood> getList() {
        return list;
    }

    public void setList(ArrayList<CatFood> list) {
        this.list = list;
    }

    @PostConstruct
    public void init(){
        list = new ArrayList<CatFood>();
    }


    //Logger logger;

    private static DecimalFormat df = new DecimalFormat(".##");



    public String addProduct(CatFood x) {
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
    public Map<CatFood, Integer> printInHashMap() {
        Map<CatFood, Integer> uniqueSet = new HashMap<CatFood, Integer>();

        for (CatFood product : list) {
            uniqueSet.computeIfAbsent(product, k -> Collections.frequency(list, product));
        }

       // logger.log(Level.INFO, String.valueOf("WAT ZIT ERIN: "+ uniqueSet.size()));

        return uniqueSet;
    }


    public Set printInHashSet() {
       // int number=0;
        System.out.println("Example with Sets and Hashset");
        Set<CatFood> uniqueSet = new HashSet<CatFood>(list);

        for (CatFood temp : uniqueSet) {
            System.out.println(temp.getId() + ": " + Collections.frequency(list, temp));
            Collections.frequency(list, temp);

        }

       return uniqueSet;
    }


    public String calculatePrice(){
        double total= 0;
        for (CatFood food : list ){
            total += food.getPrice();
        }
        String priceProduct = convertD(total);
        return priceProduct;

    }

    private String convertD(double total) {
        String price = new DecimalFormat("#0.00").format(total);
        return price;

    }

    public void removeProduct(CatFood x){
      //  for(int i =0; i < list.size(); i++) {
        //    if (x.getId() == list.get(i).getId()) {
                // list.remove(i);
                // break;
                list.remove(x);
             //   break;
          //  }
      //  }
    }


    public int getSize() {
        if(list.isEmpty()){
            return 0;
        }
       return list.size();
    }

    public String homePage(){
        return "index.xhtml";
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
