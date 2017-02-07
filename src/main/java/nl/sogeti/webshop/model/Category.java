package nl.sogeti.webshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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


    @ManyToMany
    private List<Product> products;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
