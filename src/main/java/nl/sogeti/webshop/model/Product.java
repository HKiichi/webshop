package nl.sogeti.webshop.model;


import javax.persistence.*;

/**
 * Created by ikikuchi on 13-1-2017.
 */
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue
    private int productId;

    private String name;

    private String description;


    private double price;

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
        Product catFood = (Product) o;
        return id == catFood.id;
    }*/

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        else if (this == obj)
            return true;
        else
            return this.hashCode() == ((Product) obj).hashCode();
    }

    @Override
    public int hashCode() {
        return this.getProductId();
    }


}
