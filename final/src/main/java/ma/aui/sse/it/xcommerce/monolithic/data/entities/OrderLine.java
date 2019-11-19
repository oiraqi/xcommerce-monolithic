package ma.aui.sse.it.xcommerce.monolithic.data.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Omar IRAQI
 */
@Entity
public class OrderLine extends BaseEntity {

    private static final long serialVersionUID = -2465717954068251960L;

    @ManyToOne
    @NotNull
    private Order order;

    @ManyToOne
    @NotNull
    private Product product;

    private int quantity;
    private float discount;
    private float unitPrice;
    private transient float price;

    protected OrderLine(){ }

    public OrderLine(Order order, Product product, int quantity){
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        discount = product.getDiscount();
        unitPrice = product.getPrice();
        price = unitPrice * (1 - discount / 100) * quantity;
    }

    /*public Order getOrder() {
        return order;
    }*/

    public float getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getDiscount() {
        return discount;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

}