package ma.aui.sse.it.xcommerce.monolithic.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;

import ma.aui.sse.it.xcommerce.monolithic.data.ShoppingCart;
import ma.aui.sse.it.xcommerce.monolithic.data.repositories.ProductRepository;
import ma.aui.sse.it.xcommerce.monolithic.data.entities.Product;

/**
 *
 * @author Omar IRAQI
 */
@Service
public class ShoppingCartService {

    @Autowired
    private ProductRepository productRepository;

    @Cacheable(value = "ShoppingCart")
    public ShoppingCart getShoppingCart(long userId){
        return new ShoppingCart();
    }

    @CachePut(value = "ShoppingCart", key = "#userId")
    public ShoppingCart addProduct(ShoppingCart shoppingCart, long userId, long productId, int quantity){
        Product product = productRepository.findById(productId).get();
        shoppingCart.addProduct(product, quantity);
        return shoppingCart;
    }

    @CachePut(value = "ShoppingCart", key = "#userId")
    public ShoppingCart removeProduct(ShoppingCart shoppingCart, long userId, long productId, int quantity){
        Product product = productRepository.findById(productId).get();
        shoppingCart.removeProduct(product, quantity);
        return shoppingCart;
    }

    @CachePut(value = "ShoppingCart", key = "#customerId")
    public ShoppingCart removeProduct(ShoppingCart shoppingCart, long customerId, long productId){
        Product product = productRepository.findById(productId).get();
        shoppingCart.removeProduct(product);
        return shoppingCart;
    }

    @CachePut(value = "ShoppingCart", key = "#customerId")
    public ShoppingCart empty(ShoppingCart shoppingCart, long customerId){
        shoppingCart.empty();
        return shoppingCart;
    }
}