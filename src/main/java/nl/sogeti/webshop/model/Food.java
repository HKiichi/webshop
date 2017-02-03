package nl.sogeti.webshop.model;


import javax.persistence.*;

/**
 * Created by ikikuchi on 13-1-2017.
 */
@Entity
@Table
public class Food {
    @Id
    @GeneratedValue
    private int foodId;

    private String name;

    private String description;


    private double price;

    public Food() {
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food catFood = (Food) o;
        return id == catFood.id;
    }*/

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        else if (this == obj)
            return true;
        else
            return this.hashCode() == ((Food) obj).hashCode();
    }

    @Override
    public int hashCode() {
        return this.getFoodId();
    }


}
