package ma.aui.sse.it.xcommerce.monolithic.data;

public class DTO {

    private long productId;
    private int quantity;

    public DTO() {

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