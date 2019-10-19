package ma.aui.sse.it.xcommerce.monolithic.data.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *
 * @author Omar IRAQI
 */
@Entity
public class Product extends AbstractEntity {
    
    private static final long serialVersionUID = 730736845770996539L;

    @NotNull
    private String barcode;

    @NotNull
    private String name;

    @ManyToOne
    @NotNull
    private Brand brand;

    @NotNull
    private float price;

    private float discount;

    @ManyToOne
    @NotNull
    private Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Review> reviews;

    private int quantity;
    private float weight;
    private boolean active;    

    protected Product() { }

    public Product(String name, String barcode, Brand brand, Category category, float price, int quantity, float weight) {
        this.name = name;
        this.barcode = barcode;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        discount = 0;
        active = false;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void toggleActive() {
        active = !active;
    }

    public boolean isActive() {
        return active;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other){
        if(other == null || !(other instanceof Product))
            return false;
        
        return id.longValue() == ((Product)other).getId().longValue();
    }

    @Override
    public int hashCode(){
        return (int)id.longValue();
    }

    /**
     * @return the barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * @param barcode the barcode to set
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
