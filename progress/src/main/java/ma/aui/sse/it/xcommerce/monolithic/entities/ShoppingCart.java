package ma.aui.sse.it.xcommerce.monolithic.entities;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;


/**
 *
 * @author Omar IRAQI
 */
public class ShoppingCart implements Serializable {
    
    private static final long serialVersionUID = 1718078099996510259L;
    private Hashtable<Product, Integer> selectedProducts;
    private float productsTotalPrice;
    private float shippingCost;
    private static final float BASE_SHIPPING_COST = 25;

    public ShoppingCart(){
        selectedProducts = new Hashtable<Product, Integer>();
        productsTotalPrice = 0;
        shippingCost = 0;
    }

    public void addProduct(Product product, int quantity){
        if(quantity <= 0)
            return;
        updateProduct(product, quantity);
    }

    public void removeProduct(Product product, int quantity){
        if(quantity <= 0)
            return;
        updateProduct(product, -1 * quantity);
    }

    public void removeProduct(Product product){
        if(selectedProducts.get(product) != null)
            removeProduct(product, selectedProducts.get(product));
    }

    private void updateProduct(Product product, int quantity) {
        int currentQuantity = 0;
        if(selectedProducts.get(product) != null)
            currentQuantity = selectedProducts.get(product);
        
        if(quantity + currentQuantity <= 0)
            selectedProducts.remove(product);
        else
            selectedProducts.put(product, quantity + currentQuantity);
        
        //Recompute productsTotalPrice and shippingCost
        //We could just update them, but a discount may be applied by back office meanwhile
        Iterator<Entry<Product, Integer>> it = selectedProducts.entrySet().iterator();
        productsTotalPrice = 0;
        shippingCost = 0;
        while(it.hasNext()){
            Entry<Product, Integer> e = it.next();
            productsTotalPrice += e.getKey().getPrice() * (1 - e.getKey().getDiscount() / 100) * e.getValue();
            shippingCost += e.getKey().getWeight() * e.getValue();
        }        
    }

    public float getProductsTotalPrice() {
        return productsTotalPrice;
    }

    public float getShippingCost() {
        return shippingCost;
    }

    public float getTotalPrice() {
        return productsTotalPrice + ((shippingCost == 0)? 0 : shippingCost + BASE_SHIPPING_COST);
    }
    
    public boolean isEmpty(){
        return productsTotalPrice == 0;
    }
    public void empty(){
        selectedProducts = new Hashtable<Product, Integer>();
        productsTotalPrice = 0;
        shippingCost = 0;
    }

    public void setShippingCost(float shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Hashtable<Product, Integer> getSelectedProducts() {
        return selectedProducts;
    }
}
