package ma.aui.sse.it.xcommerce.monolithic.data.dtos;

import java.io.Serializable;

public class Product implements Serializable{

    private static final long serialVersionUID = 781803052368469398L;
    private long productId;
    private int quantity;


    public Product() {

    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantiy) {
        this.quantity = quantiy;
    }
}