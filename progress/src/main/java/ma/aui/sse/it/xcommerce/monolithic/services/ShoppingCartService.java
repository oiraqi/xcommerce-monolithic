package ma.aui.sse.it.xcommerce.monolithic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.aui.sse.it.xcommerce.monolithic.data.ShoppingCart;
// import ma.aui.sse.it.xcommerce.monolithic.data.entities.Product;
import ma.aui.sse.it.xcommerce.monolithic.data.repositories.ProductRepository;

@Service
public class ShoppingCartService {

    @Autowired
    ProductRepository productRepository;

    public ShoppingCart getShoppingCart(long userId) {
        return new ShoppingCart();
    }

    public void addProduct(long productId, int quantity, long userId) {

        // Product product = productRepository.findById(productId).get();
    }

}