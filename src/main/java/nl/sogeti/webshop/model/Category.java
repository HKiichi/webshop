package nl.sogeti.webshop.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ikikuchi on 7-2-2017.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue
    private int categoryId;

    private String categoryName;


    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public int getCategoryId() {
        return categoryId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
