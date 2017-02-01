package nl.sogeti.webshop.product;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Created by ikikuchi on 13-1-2017.
 */
@Entity
@Table
public class CatFood {
    @Id
    @GeneratedValue

    private int id;


    private String name;


    private String description;


    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        CatFood catFood = (CatFood) o;
        return id == catFood.id;
    }*/

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        else if (this == obj)
            return true;
        else
            return this.hashCode() == ((CatFood) obj).hashCode();
    }

    @Override
    public int hashCode() {
        return this.getId();
    }



}
