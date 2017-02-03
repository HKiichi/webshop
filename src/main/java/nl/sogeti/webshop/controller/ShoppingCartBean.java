package nl.sogeti.webshop.controller;

import nl.sogeti.webshop.model.Food;
import nl.sogeti.webshop.service.AbstractCrudRepository;

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

    ArrayList <Food> list;


    public ArrayList<Food> getList() {
        return list;
    }

    public void setList(ArrayList<Food> list) {
        this.list = list;
    }

    @PostConstruct
    public void init(){
        list = new ArrayList<Food>();
    }


    //Logger logger;

    private static DecimalFormat df = new DecimalFormat(".##");



    public String addProduct(Food x) {
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
    public Map<Food, Integer> printInHashMap() {
        Map<Food, Integer> uniqueSet = new HashMap<Food, Integer>();

        for (Food product : list) {
            uniqueSet.computeIfAbsent(product, k -> Collections.frequency(list, product));
        }

       // logger.log(Level.INFO, String.valueOf("WAT ZIT ERIN: "+ uniqueSet.size()));

        return uniqueSet;
    }


 /*   public Set printInHashSet() {
       // int number=0;
        System.out.println("Example with Sets and Hashset");
        Set<Food> uniqueSet = new HashSet<Food>(list);

        for (Food temp : uniqueSet) {
            System.out.println(temp.getFoodId() + ": " + Collections.frequency(list, temp));
            Collections.frequency(list, temp);

        }

       return uniqueSet;
    }*/


    public String calculatePrice(){
        double total= 0;
        for (Food food : list ){
            total += food.getPrice();
        }
        String priceProduct = convertD(total);
        return priceProduct;

    }

    private String convertD(double total) {
        String price = new DecimalFormat("#0.00").format(total);
        return price;

    }

    public void removeProduct(Food x){
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
