package ma.aui.sse.it.xcommerce.monolithic.data.entities;

import java.util.List;
import java.util.Map.Entry;
import java.util.Iterator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ma.aui.sse.it.xcommerce.monolithic.data.dtos.ShoppingCart;

/**
 *
 * @author Omar IRAQI
 */
@Entity
@Table(name = "\"order\"")
public class Order extends BaseEntity {

    private static final long serialVersionUID = 3959935433240472748L;

    @ManyToOne
    @NotNull
    protected User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected List<OrderLine> orderLines;

    protected OrderStatus status;
    protected float productsTotalPrice;
    protected float shippingCost;
    protected static final float TAX_RATE = (float) 0.2;

    protected Order() {
    }

    public Order(ShoppingCart shoppingCart, User user) {
        this.user = user;
        if (shoppingCart.getSelectedProducts() != null) {
            Iterator<Entry<Product, Integer>> it = shoppingCart.getSelectedProducts().entrySet().iterator();
            while (it.hasNext()) {
                Entry<Product, Integer> e = it.next();
                new OrderLine(this, e.getKey(), e.getValue());
            }
        }
        productsTotalPrice = shoppingCart.getProductsTotalPrice();
        shippingCost = shoppingCart.getShippingCost();
        status = OrderStatus.HANDLING;
    }

    public void updateStatus(OrderStatus newStatus) throws IllegalStatusChangeException {
        if (status == OrderStatus.CANCELED || status == OrderStatus.DELIVERED)
            throw new IllegalStatusChangeException(newStatus);
        status = newStatus;
        // use JavaMail API to send a notification to the customer by email
    }

    public User getUser() {
        return user;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public float getProductsTotalPrice() {
        return productsTotalPrice;
    }

    public void setProductsTotalPrice(float productsTotalPrice) {
        this.productsTotalPrice = productsTotalPrice;
    }

    public float getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(float shippingCost) {
        this.shippingCost = shippingCost;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}