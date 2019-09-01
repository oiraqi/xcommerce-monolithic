package ma.aui.sse.it.xcommerce.monolithic.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Omar IRAQI
 */
@Entity
public class Category extends AbstractEntity {
    
    private static final long serialVersionUID = 512632343574588379L;

    @NotNull
    private String name; // read-only

    @ManyToOne
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory", fetch = FetchType.LAZY)
    @OrderBy("name asc")
    private List<Category> subCategories;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @OrderBy("name asc")
    private List<Product> products;
    
    protected Category(){ }

    public Category(String name, Category parentCategory){
        this.name = name;
        this.parentCategory = parentCategory;
    }

    public Category(String name){
        this(name, null);
    }

    public String getName() {
        return name;
    }

    public Category getParentCategory(){
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory){
        this.parentCategory = parentCategory;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the subCategories
     */
    public List<Category> getSubCategories() {
        return subCategories;
    }

    /**
     * @param subCategories the subCategories to set
     */
    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

    /**
     * @return the products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}